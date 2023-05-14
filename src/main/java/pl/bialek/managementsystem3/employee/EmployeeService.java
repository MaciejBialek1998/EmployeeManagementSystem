package pl.bialek.managementsystem3.employee;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bialek.managementsystem3.employee.dto.EmployeeMainPageDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeModifyDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeRegistrationDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeShowDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeTransactionDto;
import pl.bialek.managementsystem3.employee.role.EmployeeRole;
import pl.bialek.managementsystem3.employee.role.EmployeeRoleRepository;
import pl.bialek.managementsystem3.employee.utils.EmployeeMapper;
import pl.bialek.managementsystem3.employee.utils.EmployeeUtils;
import pl.bialek.managementsystem3.task.TaskMapper;
import pl.bialek.managementsystem3.task.dto.TaskMainDto;
import pl.bialek.managementsystem3.employeeDetails.EmployeeDetailsRepository;
import pl.bialek.managementsystem3.employeeDetails.EmployeeDetails;

import java.util.*;

@Service
public class EmployeeService {

    private final String EMPLOYEE_ROLE = "EMPLOYEE";

    private EmployeeDetailsRepository detailsRepository;
    private EmployeeRoleRepository roleRepository;

    private EmployeeRepository repository;

    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeDetailsRepository detailsRepository, EmployeeRoleRepository roleRepository, EmployeeRepository repository, PasswordEncoder passwordEncoder) {
        this.detailsRepository = detailsRepository;
        this.roleRepository = roleRepository;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Iterable<EmployeeShowDto> getAllEmployees(){
        Iterator<Employee> iterator = findAll().iterator();
        ArrayList<EmployeeShowDto> employeeShowDtos = new ArrayList<>();
        while(iterator.hasNext())
            employeeShowDtos.add(EmployeeMapper.employeeToShow(iterator.next()));
        return employeeShowDtos;
    }

    public Iterable<Employee> findAll(){
        return repository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id){
        return repository.findById(id);
    }


    private Optional<Employee> findBaseEmployeeByPesel(String pesel){
       return repository.findEmployeeByPesel(pesel);
    }

    @Transactional
    public Optional<EmployeeMainPageDto> findEmployeeByPesel(String pesel){
        return findBaseEmployeeByPesel(pesel).map(EmployeeMapper::map);
    }

    @Transactional
    public void registerEmployee(EmployeeRegistrationDto employeeRegistration){
        EmployeeDetails employeeDetails = createDetails(employeeRegistration);
        Employee employee = createEmployee(employeeRegistration, employeeDetails);
        try{
            repository.save(employee);
        }catch (DataIntegrityViolationException e){
        }


    }

    private EmployeeDetails createDetails(EmployeeRegistrationDto employeeRegistration){
        return new EmployeeDetails(employeeRegistration.getEmail(),employeeRegistration.getPhoneNumber()
                ,employeeRegistration.getCity());
    }


    private Employee createEmployee(EmployeeRegistrationDto employeeRegistration, EmployeeDetails employeeDetails){
        Employee employee = new Employee();
        EmployeeMapper.registrationToEmployeed(employee,employeeRegistration,employeeDetails);
        employee.setPassword(passwordEncoder.encode(employeeRegistration.getPassword()));
        Optional<EmployeeRole> role = roleRepository.findEmployeeRoleByRole(EMPLOYEE_ROLE);
        role.ifPresentOrElse(
                r -> employee.getRoles().add(r),
                () -> {
                    throw new NoSuchElementException();
                }
        );
        return employee;
    }

    public void convertDetailsIfEmpty(EmployeeTransactionDto transactionDto){
        EmployeeUtils.convertDetailsIfEmpty(transactionDto);
    }

    public Optional<EmployeeModifyDto> getEmployeeToModify(Long id){
        Optional<Employee> employee = findEmployeeById(id);
        return employee.map(this::createEmployeeModify);
    }

    private EmployeeModifyDto createEmployeeModify(Employee employee){
        return EmployeeMapper.mapModify(employee);
    }
    @Transactional
    public void modifyEmployeeData(EmployeeModifyDto employeeModifyDto){
        Employee employee = findEmployeeById(employeeModifyDto.getId()).get();
        EmployeeMapper.modifyToEmployee(employee,employeeModifyDto);
        saveEmployeeModifications(employee);
    }
    @Transactional
    public void saveEmployeeModifications(Employee employee){
        saveEmployee(employee);
    }

    private void saveEmployee(Employee employee){
        try{
            repository.save(employee);
        }catch (DataIntegrityViolationException e){
        }
    }

    @Transactional
    public boolean removeEmployee(Long id){
        Optional<Employee> employeeById = findEmployeeById(id);
        if(EmployeeUtils.checkIfEmpty(employeeById))
            return false;
        Employee employee = employeeById.get();
        deleteEmployee(employee);
        deleteEmployeeDetails(employee.getDetailsId());
        return true;
    }

    private void deleteEmployee(Employee employee){
        repository.delete(employee);
    }

    private void deleteEmployeeDetails(EmployeeDetails employeeDetails) {
        detailsRepository.delete(employeeDetails);
    }

    public Iterable<TaskMainDto> getTasks(EmployeeMainPageDto employee){
        Iterable<TaskMainDto> tasks = employee.getTasks().stream().map(TaskMapper::mapToTaskMainDto).toList();
        return tasks;
    }

    public Optional<Employee> getEmployee(String pesel){
        return findBaseEmployeeByPesel(pesel);
    }

}

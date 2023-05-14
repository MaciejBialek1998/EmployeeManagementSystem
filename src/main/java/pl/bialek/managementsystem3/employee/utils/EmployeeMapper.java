package pl.bialek.managementsystem3.employee.utils;

import pl.bialek.managementsystem3.employee.Employee;
import pl.bialek.managementsystem3.employeeDetails.EmployeeDetails;
import pl.bialek.managementsystem3.employee.dto.EmployeeMainPageDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeModifyDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeRegistrationDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeShowDto;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeTransactionDto;
import pl.bialek.managementsystem3.employee.role.EmployeeRole;

import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeMainPageDto map(Employee employee){
        Set<String> roles = employee.getRoles().stream().map(EmployeeRole::getRole).collect(Collectors.toSet());
        return new EmployeeMainPageDto(employee.getId(),employee.getPesel(), employee.getFirstName(), employee.getPassword(),roles,employee.getTasks());
    }

    public static EmployeeModifyDto mapModify(Employee employee){
        return new EmployeeModifyDto(employee.getId(),employee.getFirstName(), employee.getLastName()
                ,employee.getSalary(),employee.getPosition()
                ,employee.getDetailsId().getEmail(),employee.getDetailsId().getPhoneNumber(),employee.getDetailsId().getCity());
    }


    public static void registrationToEmployeed(Employee employee, EmployeeRegistrationDto employeeRegistration, EmployeeDetails employeeDetails){
        transactionToEmployeed(employee,employeeRegistration);
        employee.setPesel(employeeRegistration.getPesel());
        employee.setDetailsId(employeeDetails);
    }

    private static void transactionToEmployeed(Employee employee, EmployeeTransactionDto employeeTransactionDto){
        employee.setFirstName(employeeTransactionDto.getFirstName());
        employee.setLastName(employeeTransactionDto.getLastName());
        employee.setSalary(employeeTransactionDto.getSalary());
        employee.setPosition(employeeTransactionDto.getPosition());
    }

    public static void modifyToEmployee(Employee employee, EmployeeModifyDto employeeModifyDto){
        transactionToEmployeed(employee,employeeModifyDto);
        employee.getDetailsId().setEmail(employeeModifyDto.getEmail());
        employee.getDetailsId().setPhoneNumber(employeeModifyDto.getPhoneNumber());
        employee.getDetailsId().setCity(employeeModifyDto.getCity());
    }

    public static EmployeeShowDto employeeToShow(Employee employee){
        return new EmployeeShowDto(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getPosition(), employee.getId(), employee.getPesel(), employee.getDetailsId().getEmail(), employee.getDetailsId().getPhoneNumber());
    }

}

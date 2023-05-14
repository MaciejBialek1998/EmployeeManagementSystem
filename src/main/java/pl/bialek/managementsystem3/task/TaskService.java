package pl.bialek.managementsystem3.task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bialek.managementsystem3.employee.Employee;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.employee.utils.EmployeeUtils;
import pl.bialek.managementsystem3.task.dto.TaskDto;
import pl.bialek.managementsystem3.task.dto.TaskRepository;
import pl.bialek.managementsystem3.task.utils.TaskUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeService employeeService;

    public TaskService(TaskRepository taskRepository, EmployeeService employeeService) {
        this.taskRepository = taskRepository;
        this.employeeService = employeeService;
    }

    @Transactional
    public void createTask(TaskDto taskDto, Long employeeId){
        Task task = TaskMapper.mapToTask(taskDto);
        task.setStatus(Status.NOT_STARTED.getName());
        Employee employee = employeeService.findEmployeeById(employeeId).get();
        employee.addTask(task);
        employeeService.saveEmployeeModifications(employee);
    }

    public void convertTitleIfEmpty(TaskDto taskDto){
        TaskUtils.convertTitleIfEmpty(taskDto);
    }

    private void deleteTask(Task task){
        taskRepository.delete(task);
    }

    private void modifyTask(Task task){
        taskRepository.save(task);
    }

    @Transactional
    public boolean updateTaskProgress(String pesel, Long id) {

    Optional<Employee> employeeOptional = employeeService.getEmployee(pesel);
    if(EmployeeUtils.checkIfEmpty(employeeOptional))
        return false;
    Employee employee  = employeeOptional.get();
    return update(employee.getTasks(),id);
    }

    private boolean update(List<Task> tasks, Long id){
        Iterator<Task> iteratedTasks = tasks.iterator();
        while(iteratedTasks.hasNext()){
            Task task = iteratedTasks.next();
            if(task.getId().equals(id)){
                if(task.getStatus().equals(Status.NOT_STARTED.getName())){
                    changeStatusOfTask(task);
                }else{
                    tasks.remove(task);
                    deleteTask(task);
                }
                return true;
            }
        }
        return false;
    }

    private void changeStatusOfTask(Task task){
        task.setStatus(Status.IN_PROGRESS.getName());
        modifyTask(task);
    }

}

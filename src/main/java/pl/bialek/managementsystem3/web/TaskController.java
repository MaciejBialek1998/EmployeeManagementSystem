package pl.bialek.managementsystem3.web;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeShowDto;
import pl.bialek.managementsystem3.task.TaskService;
import pl.bialek.managementsystem3.task.dto.TaskDto;

@Controller
public class TaskController {

    private EmployeeService employeeService;
    private TaskService taskService;

    public TaskController(EmployeeService employeeService, TaskService taskService) {
        this.employeeService = employeeService;
        this.taskService = taskService;
    }

    @GetMapping("create-task")
    String goToCreateTask(Model model){
        addAttributes(model);
        model.addAttribute("task",new TaskDto());
        return "admin/create-task";
    }

    @PostMapping("create-task")
    String createTask(@Valid @ModelAttribute("task") TaskDto taskDto, BindingResult result, @RequestParam Long employeeToTask, RedirectAttributes model){
        taskService.convertTitleIfEmpty(taskDto);
        if(result.hasErrors()){
            addAttributes(model);
            return "admin/create-task";
        }
            model.addFlashAttribute("message","Task created");
            taskService.createTask(taskDto,employeeToTask);
            return "redirect:/";

    }

    @GetMapping("/status")
    String changeStatus(@RequestParam Long id, Authentication authentication, RedirectAttributes model){
        if(taskService.updateTaskProgress(authentication.getName(),id)){
            model.addFlashAttribute("message","Task status updated");
            return "redirect:/";
            //return "redirect:/confirmation";

        }
        return "redirect:/";
    }


    private void addAttributes(Model model){
        Iterable<EmployeeShowDto> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
    }

}

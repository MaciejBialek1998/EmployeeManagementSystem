package pl.bialek.managementsystem3.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.employee.dto.EmployeeMainPageDto;
import pl.bialek.managementsystem3.task.dto.TaskMainDto;

import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {
    private final EmployeeService service;

    public HomeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    String home(Authentication authentication, Model model){
        EmployeeMainPageDto employee = service.findEmployeeByPesel(authentication.getName()).get();
        Iterable<TaskMainDto> tasks = service.getTasks(employee);
        model.addAttribute("employee",employee);
        model.addAttribute("tasks",tasks);
        return "index";
    }

}

package pl.bialek.managementsystem3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeShowDto;

@Controller
public class AdminController {

    private final EmployeeService service;

    public AdminController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("show-employees")
    String showEmployees(Model model){
        Iterable<EmployeeShowDto> employees = service.getAllEmployees();
        model.addAttribute("employees",employees);
        return "admin/show-employees";
    }


}

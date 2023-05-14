package pl.bialek.managementsystem3.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeRegistrationDto;

@Controller
public class RegisterController {

    private final EmployeeService service;

    public RegisterController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("register")
    String loadPage(Model model){
        model.addAttribute("employee",new EmployeeRegistrationDto());
        return "admin/registration-form";
    }

    @PostMapping("register")
    String register(@Valid  @ModelAttribute("employee") EmployeeRegistrationDto employee, BindingResult result, RedirectAttributes redirectAttrs){
        service.convertDetailsIfEmpty(employee);
        if(result.hasErrors()){
            return "admin/registration-form";
        }
            try{
            service.registerEmployee(employee);
            redirectAttrs.addFlashAttribute("message", "Employee added");
            return "redirect:/show-employees";
        }catch (UnexpectedRollbackException e){
            redirectAttrs.addAttribute("message","Pesel or password is already used");
            return "admin/registration-form";
        }
    }

}

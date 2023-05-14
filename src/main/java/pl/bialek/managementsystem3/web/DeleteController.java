package pl.bialek.managementsystem3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.utils.ModelUtils;

@Controller
public class DeleteController {

    private EmployeeService service;

    public DeleteController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/delete")
    String delete(@RequestParam(required = true) Long id, RedirectAttributes model){
        if(!service.removeEmployee(id))
            ModelUtils.addMessage(model,"Can't remove employee");
        else
            ModelUtils.addMessage(model,"Employee removed");
        return "redirect:/show-employees";
    }

}

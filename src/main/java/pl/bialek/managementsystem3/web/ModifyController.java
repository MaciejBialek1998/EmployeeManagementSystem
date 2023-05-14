package pl.bialek.managementsystem3.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bialek.managementsystem3.employee.EmployeeService;
import pl.bialek.managementsystem3.employee.dto.transactiondto.EmployeeModifyDto;

import java.util.Optional;

@Controller
public class ModifyController {

    private final EmployeeService service;

    public ModifyController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/modify")
    String manage(@RequestParam(required = true, defaultValue = "1") Long id, Model model){
        Optional<EmployeeModifyDto> employeeToModify = service.getEmployeeToModify(id);
        if(employeeToModify.isPresent()){
            addAttributes(model,id,employeeToModify.get());
            return "admin/modify-form";
        }
        return "redirect:/modify";
    }

    @PostMapping("/modify")
    String modify(@RequestParam(required = true, defaultValue = "0") Long id
            , @Valid @ModelAttribute("modifiedEmployee") EmployeeModifyDto employeeModifyDto, BindingResult result, RedirectAttributes model){
        if(service.getEmployeeToModify(id).isPresent()){
            service.convertDetailsIfEmpty(employeeModifyDto);
            if(result.hasErrors()){
                addAttributes(model,id,employeeModifyDto);
                return "admin/modify-form";
            }
            service.modifyEmployeeData(employeeModifyDto);
            model.addFlashAttribute("message", "Employee data modified");
                return "redirect:/show-employees";
        }
        model.addFlashAttribute("message", "Can't find employee");
        return "admin/show-employees";
    }

    private void addAttributes(Model model, Long id, EmployeeModifyDto employeeModifyDto){
        model.addAttribute("id",id);
        model.addAttribute("modifiedEmployee",employeeModifyDto);
    }

}
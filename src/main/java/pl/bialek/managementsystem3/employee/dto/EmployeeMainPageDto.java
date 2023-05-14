package pl.bialek.managementsystem3.employee.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.bialek.managementsystem3.task.Task;

import java.util.List;
import java.util.Set;

@Getter
public class EmployeeMainPageDto {

    private Long id;
    @PESEL
    private String pesel;
    @NotNull
    @Size(min = 2,max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    private String firstName;
    @NotNull
    @Size(min = 2,max = 45)
    private String password;
    private Set<String> employeeRoles;

    private List<Task> tasks;

    public EmployeeMainPageDto(Long id, String pesel, String firstName, String password, Set<String> employeeRoles, List<Task> tasks) {
        this.id = id;
        this.pesel = pesel;
        this.firstName = firstName;
        this.password = password;
        this.employeeRoles = employeeRoles;
        this.tasks = tasks;
    }

}

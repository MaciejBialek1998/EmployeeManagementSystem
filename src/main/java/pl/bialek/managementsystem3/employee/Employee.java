package pl.bialek.managementsystem3.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.bialek.managementsystem3.employee.role.EmployeeRole;
import pl.bialek.managementsystem3.task.Task;
import pl.bialek.managementsystem3.employeeDetails.EmployeeDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PESEL
    private String pesel;

    @NotNull
    @Size(min = 2,max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    private String firstName;
    @NotNull
    @Size(min = 2,max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    private String lastName;
    @NotNull
    @Min(value = 0)
    protected BigDecimal salary;
    @NotNull
    @Pattern(regexp = "[A-Za-z]+")
    protected String position;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="details_id",unique = true)
    private EmployeeDetails detailsId;
    @NotNull
    @Size(min = 2, max = 128)
    private String password;



    @ManyToMany()
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<EmployeeRole> roles = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Task> tasks = new ArrayList<>();

    public Employee() {
    }

    public Employee(String pesel, String firstName, String lastName, BigDecimal salary, String position, EmployeeDetails detailsId, String password) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.detailsId = detailsId;
        this.password = password;
    }

    public void addTask(Task task){getTasks().add(task);}

}

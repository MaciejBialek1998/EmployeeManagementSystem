package pl.bialek.managementsystem3.employee.dto.transactiondto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public abstract class EmployeeDto {

    @NotNull
    @Size(min = 2,max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    protected String firstName;
    @NotNull
    @Size(min = 2,max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    protected String lastName;
    @NotNull
    @Min(value = 0)
    protected BigDecimal salary;
    @NotNull
    @Size(min = 2,max = 32)
    @Pattern(regexp = "[A-Za-z]+")
    protected String position;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, BigDecimal salary, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
    }

}

package pl.bialek.managementsystem3.employee.dto.transactiondto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class EmployeeTransactionDto extends EmployeeDto{

    @Email
    protected String email;
    @Size(min = 9,max = 9)
    @Pattern(regexp = "[0-9]{9}")
    protected String phoneNumber;
    @Size(max = 16)
    protected String city;

    public EmployeeTransactionDto() {
        super();
    }

    public EmployeeTransactionDto(String firstName, String lastName, BigDecimal salary, String position, String email, String phoneNumber, String city) {
        super(firstName, lastName, salary, position);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

}

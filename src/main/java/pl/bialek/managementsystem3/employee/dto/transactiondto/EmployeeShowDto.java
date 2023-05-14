package pl.bialek.managementsystem3.employee.dto.transactiondto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.pl.PESEL;

import java.math.BigDecimal;

@Getter
public class EmployeeShowDto extends EmployeeDto{

    private Long id;
    @PESEL
    protected String pesel;

    @Email
    protected String email;
    @Size(min = 9,max = 9)

    @Pattern(regexp = "[0-9]{9}")
    protected String phoneNumber;

    public EmployeeShowDto(String firstName, String lastName, BigDecimal salary, String position, Long id, String pesel, String email, String phoneNumber) {
        super(firstName, lastName, salary, position);
        this.id = id;
        this.pesel = pesel;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

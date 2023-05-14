package pl.bialek.managementsystem3.employee.dto.transactiondto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

@Getter
@Setter
public class EmployeeRegistrationDto extends EmployeeTransactionDto{

    @PESEL
    protected String pesel;

    @NotNull
    @Size(min = 2, max = 32)
    private String password;


    public String getPesel() {
        return pesel;
    }


    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}

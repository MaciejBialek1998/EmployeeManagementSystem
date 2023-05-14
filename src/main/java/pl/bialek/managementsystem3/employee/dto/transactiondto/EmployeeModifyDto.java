package pl.bialek.managementsystem3.employee.dto.transactiondto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class EmployeeModifyDto extends EmployeeTransactionDto {

    private Long id;

    public EmployeeModifyDto(Long id, String firstName, String lastName, BigDecimal salary, String position, String email, String phoneNumber, String city) {
        super(firstName,lastName,salary,position,email,phoneNumber,city);
        this.id = id;
    }


}

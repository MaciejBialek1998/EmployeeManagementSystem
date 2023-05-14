package pl.bialek.managementsystem3.employeeDetails;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDetailsDto {

    @Email
    private String email;
    @Size(min = 9,max = 9)
    @Pattern(regexp = "[0-9]{9}")
    private String phoneNumber;

    @Pattern(regexp = "[a-z]")
    private String city;

}

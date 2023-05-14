package pl.bialek.managementsystem3.employeeDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String email;
    @Size(min = 9,max = 9)
    @Pattern(regexp = "[0-9]{9}")
    private String phoneNumber;

    private String city;

    public EmployeeDetails() {
    }

    public EmployeeDetails(String email, String phoneNumber, String city) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public EmployeeDetails(Long id, String email, String phoneNumber, String city) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                '}';
    }
}

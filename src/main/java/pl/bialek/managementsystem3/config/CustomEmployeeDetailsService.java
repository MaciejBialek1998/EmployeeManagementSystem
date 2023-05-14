package pl.bialek.managementsystem3.config;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.bialek.managementsystem3.employee.EmployeeService;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    EmployeeService service;

    public CustomEmployeeDetailsService(EmployeeService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        return service.findEmployeeByPesel(pesel).map(employeeDto -> User.builder().username(employeeDto.getPesel()).password(employeeDto.getPassword()).roles(employeeDto.getEmployeeRoles().toArray(String[]::new)))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", pesel))).build();

    }
}

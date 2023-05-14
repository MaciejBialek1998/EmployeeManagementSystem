package pl.bialek.managementsystem3.employee;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Optional<Employee> findEmployeeByPesel(String pesel);


}

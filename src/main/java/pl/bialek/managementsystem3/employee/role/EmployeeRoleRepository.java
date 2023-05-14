package pl.bialek.managementsystem3.employee.role;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRoleRepository extends CrudRepository<EmployeeRole,Long> {

    public Optional<EmployeeRole> findEmployeeRoleByRole(String role);

}

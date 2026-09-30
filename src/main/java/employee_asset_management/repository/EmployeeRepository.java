package employee_asset_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import employee_asset_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}

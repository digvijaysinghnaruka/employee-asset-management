package employee_asset_management.service;

import employee_asset_management.entity.Employee;
import employee_asset_management.exception.EmployeeNotFoundException;
import employee_asset_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Long id, Employee employee){
        Employee existingEmployee =employeeRepository.findById(id).orElse(null);
        if(existingEmployee == null){
            return null;
        }
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

}

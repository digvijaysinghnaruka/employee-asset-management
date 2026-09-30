package employee_asset_management.controller;

import employee_asset_management.entity.Employee;
import employee_asset_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import employee_asset_management.dto.EmployeeRequestDTO;
import employee_asset_management.dto.EmployeeResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api")


public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeDTO){
        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());

        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<EmployeeResponseDTO> getallEmployee(){
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream().map(employee -> {

            EmployeeResponseDTO dto = new EmployeeResponseDTO();

            dto.setId(employee.getId());
            dto.setName(employee.getName());
            dto.setEmail(employee.getEmail());
            dto.setDepartment(employee.getDepartment());

            return dto;
        }).toList();

    }
    @GetMapping("/employees/{id}")
    public EmployeeResponseDTO getEmployeesById(@PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id);

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());

        return dto;
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
}

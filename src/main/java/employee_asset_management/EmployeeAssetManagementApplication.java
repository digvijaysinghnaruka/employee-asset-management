package employee_asset_management;

import employee_asset_management.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class EmployeeAssetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAssetManagementApplication.class, args);
	}

}

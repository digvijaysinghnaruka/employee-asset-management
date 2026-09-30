package employee_asset_management.entity;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;



@Entity
public class Asset {
 @Id
 @GeneratedValue

 private Long id;
 private String name;
 private String type;
 private String serialNumber;
 @Enumerated(EnumType.STRING)
 private AssetStatus status;
 @ManyToOne
 private Employee employee;


 public Asset(){

 }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public AssetStatus getStatus() {
        return status;
    }

    public void setStatus(AssetStatus status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

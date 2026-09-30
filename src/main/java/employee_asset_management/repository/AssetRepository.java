package employee_asset_management.repository;
import employee_asset_management.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long>{
}

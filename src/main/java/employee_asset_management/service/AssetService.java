package employee_asset_management.service;

import employee_asset_management.entity.Asset;
import employee_asset_management.entity.AssetStatus;
import employee_asset_management.entity.Employee;
import employee_asset_management.repository.AssetRepository;
import employee_asset_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;
    private final EmployeeRepository employeeRepository;

    public AssetService(AssetRepository assetRepository,
                        EmployeeRepository employeeRepository) {
        this.assetRepository = assetRepository;
        this.employeeRepository = employeeRepository;
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }


    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    //
    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElse(null);
    }

    public Asset updateAsset(Long id, Asset asset) {

        Asset existingAsset = assetRepository.findById(id).orElse(null);

        if (existingAsset == null) {
            return null;
        }

        existingAsset.setName(asset.getName());
        existingAsset.setType(asset.getType());
        existingAsset.setSerialNumber(asset.getSerialNumber());
        existingAsset.setStatus(asset.getStatus());

        return assetRepository.save(existingAsset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }

    public Asset assignAsset(Long assetId, Long employeeId) {

        Asset asset = assetRepository.findById(assetId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (asset == null || employee == null) {
            return null;
        }

        if (asset.getStatus() != AssetStatus.AVAILABLE) {
            return null;
        }

        asset.setEmployee(employee);
        asset.setStatus(AssetStatus.ASSIGNED);

        return assetRepository.save(asset);
    }


    public Asset returnAsset(Long assetId) {

        Asset asset = assetRepository.findById(assetId).orElse(null);

        if (asset == null) {
            return null;
        }

        if (asset.getStatus() != AssetStatus.ASSIGNED) {
            return null;
        }

        asset.setEmployee(null);
        asset.setStatus(AssetStatus.AVAILABLE);

        return assetRepository.save(asset);
    }
    public Asset repairAsset(Long assetId){
        Asset asset = assetRepository.findById(assetId).orElse(null);
        if (asset == null){
            return null;
        }
        asset.setStatus(AssetStatus.UNDER_REPAIR);
        return  assetRepository.save(asset);
    }
}
package employee_asset_management.controller;
import employee_asset_management.entity.Asset;
import employee_asset_management.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("/assets/{assetId}/assign/{employeeId}")
    public Asset assignAsset(@PathVariable Long assetId, @PathVariable Long employeeId) {
        return assetService.assignAsset(assetId, employeeId);
    }
    @PostMapping("/assets/{assetId}/return")
    public Asset returnAsset(@PathVariable Long assetId) {
        return assetService.returnAsset(assetId);
    }

    @PostMapping("/assets")
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.saveAsset(asset);
    }

    @GetMapping("/assets")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }
    @GetMapping("/assets/{id}")
    public Asset getById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }
    @PutMapping("/assets/{id}")
    public Asset updateAsset(@PathVariable Long id,@RequestBody Asset asset){
        return assetService.updateAsset(id, asset);
    }
    @DeleteMapping("/assets/{id}")
    public void deleteAsset(@PathVariable Long id){
        assetService.deleteAsset(id);
    }

    @PostMapping("/assets/{assetId}/repair")
    public Asset repairAsset(@PathVariable Long assetId){
        return assetService.repairAsset(assetId);
    }



}

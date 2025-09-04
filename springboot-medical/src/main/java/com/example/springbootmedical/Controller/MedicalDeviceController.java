package com.example.springbootmedical.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootcommon.response.Result;
import com.example.springbootmedical.Service.MedicalDeviceService;
import com.example.springbootmedical.entity.MedicalDevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class MedicalDeviceController {

    @Autowired
    private MedicalDeviceService deviceService;

    @GetMapping
    public Result<IPage<MedicalDevice>> getDeviceList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) Long departmentId) {

        IPage<MedicalDevice> page = deviceService.getDevicePage(pageNum, pageSize,
                name, model, status, departmentId);
        return Result.success(page);
    }

    @GetMapping("/{id}")
    public Result<MedicalDevice> getDeviceById(@PathVariable Long id) {
        MedicalDevice device = deviceService.getById(id);
        return device != null ? Result.success(device) : Result.error("设备不存在");
    }

    @PostMapping
    public Result<MedicalDevice> createDevice(@Valid @RequestBody MedicalDevice device) {
        boolean success = deviceService.createDevice(device);
        return success ? Result.success(device) : Result.error("创建设备失败");
    }

    @PutMapping("/{id}")
    public Result<MedicalDevice> updateDevice(@PathVariable Long id, @Valid @RequestBody MedicalDevice device) {
        boolean success = deviceService.updateDevice(id, device);
        return success ? Result.success(device) : Result.error("更新设备失败");
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteDevice(@PathVariable Long id) {
        boolean success = deviceService.deleteDevice(id);
        return success ? Result.success() : Result.error("删除设备失败");
    }
}
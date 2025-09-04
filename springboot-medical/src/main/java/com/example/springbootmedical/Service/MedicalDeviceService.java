package com.example.springbootmedical.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmedical.entity.MedicalDevice;

public interface MedicalDeviceService extends IService<MedicalDevice> {

    IPage<MedicalDevice> getDevicePage(Integer pageNum, Integer pageSize,
                                       String name, String model, Integer status, Long departmentId);

    MedicalDevice getBySerialNumber(String serialNumber);

    boolean createDevice(MedicalDevice device);

    boolean updateDevice(Long id, MedicalDevice device);

    boolean deleteDevice(Long id);
}
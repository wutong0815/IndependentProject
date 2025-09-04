package com.example.springbootmedical.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmedical.entity.MedicalDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MedicalDeviceRepository extends BaseMapper<MedicalDevice> {

    IPage<MedicalDevice> selectDevicePage(Page<MedicalDevice> page,
                                          @Param("name") String name,
                                          @Param("model") String model,
                                          @Param("status") Integer status,
                                          @Param("departmentId") Long departmentId);

    MedicalDevice findBySerialNumber(@Param("serialNumber") String serialNumber);
}

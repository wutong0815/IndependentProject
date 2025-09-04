package com.example.springbootmedical.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("medical_device")
public class MedicalDevice {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long categoryId;
    private Long institutionId;
    private Long departmentId;
    private String name;
    private String model;
    private String manufacturer;
    private String serialNumber;
    private String assetNumber;
    private LocalDateTime purchaseDate;
    private Integer warrantyPeriod;
    private BigDecimal price;
    private Integer status;
    private Integer maintenanceCycle;
    private LocalDateTime lastMaintenanceDate;
    private LocalDateTime nextMaintenanceDate;
    private String technicalParameters;
    private String operationManual;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
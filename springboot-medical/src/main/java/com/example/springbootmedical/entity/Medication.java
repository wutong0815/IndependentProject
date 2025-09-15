package com.example.springbootmedical.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 药品
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("medication")
public class Medication {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long categoryId;
    private String name;
    private String genericName;
    private String brandName;
    private String dosageForm;
    private String specification;
    private String manufacturer;
    private String approvalNumber;
    private String unit;
    private Integer stockQuantity;
    private Integer minStock;
    private BigDecimal unitPrice;
    private String description;
    private String indications;
    private String contraindications;
    private String sideEffects;
    private String storageConditions;
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
package com.example.springbootmedical.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 医疗机构
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("medical_institution")
public class MedicalInstitution {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer type;
    private Integer level;
    private String address;
    private String contactPhone;
    private String email;
    private String website;
    private LocalDateTime establishedDate;
    private String licenseNumber;
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
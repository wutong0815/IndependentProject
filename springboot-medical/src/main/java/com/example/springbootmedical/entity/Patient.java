package com.example.springbootmedical.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("patient")
public class Patient {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String medicalRecordNumber;
    private String name;
    private Integer gender;
    private LocalDateTime birthDate;
    private String idCard;
    private String contactPhone;
    private String emergencyContact;
    private String emergencyPhone;
    private String bloodType;
    private Integer rhFactor;
    private Double height;
    private Double weight;
    private String allergyHistory;
    private String medicalHistory;
    private String familyHistory;
    private String drugAllergyHistory;
    private String foodAllergyHistory;
    private String otherAllergyHistory;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}

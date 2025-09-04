package com.example.springbootmedical.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("department")
public class Department {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long institutionId;
    private String name;
    private String code;
    private String description;
    private Long parentId;
    private String leader;
    private String contactPhone;
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}

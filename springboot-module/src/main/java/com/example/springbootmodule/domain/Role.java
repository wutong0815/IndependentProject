package com.example.springbootmodule.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class Role {

    @TableId(type = IdType.AUTO)

    private Long id;

    private String roleName;
    private String roleCode;
    private Integer roleType;
    private String description;
    private Integer dataScope;
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
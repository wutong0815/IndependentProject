package com.example.springbootmodule.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springbootcommon.domain.BaseEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 50, message = "用户名长度必须在2-50个字符之间")
    @TableField("username")
    private String username;

    @NotBlank(message = "密码不能为空")
    @TableField("password")
    private String password;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;

    @TableField("nickname")
    private String nickname;

    @TableField("avatar")
    private String avatar;

    @TableField("gender")
    private Integer gender;

    @TableField("birthday")
    private LocalDateTime birthday;

    @TableField("status")
    private Integer status;

    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @TableField("last_login_ip")
    private String lastLoginIp;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}
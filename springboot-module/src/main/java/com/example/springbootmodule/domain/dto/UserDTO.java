package com.example.springbootmodule.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 50, message = "用户名长度必须在2-50个字符之间")
    private String username;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    private String phone;
    private String nickname;
    private String avatar;
    private Integer gender;
    private LocalDateTime birthday;
    private Integer status;

    // 详情信息
    private String realName;
    private String idCard;
    private String address;
    private String education;
    private String occupation;
    private String company;
    private String signature;
}
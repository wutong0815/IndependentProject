package com.example.springbootmodule.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springbootcommon.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户个人信息
 */
@Data
@TableName("user_profile")
public class UserProfile extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("real_name")
    private String realName;

    @TableField("id_card")
    private String idCard;

    @TableField("address")
    private String address;

    @TableField("education")
    private String education;

    @TableField("occupation")
    private String occupation;

    @TableField("company")
    private String company;

    @TableField("signature")
    private String signature;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}

package com.example.springbootmodule.domain.dto;

import com.example.springbootcommon.domain.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryDTO extends PageQuery {

    private String username;
    private String email;
    private String phone;
    private String nickname;
    private Integer gender;
    private Integer status;
    private String realName;
}
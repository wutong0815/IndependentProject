package com.example.springbootmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmodule.domain.User;
import com.example.springbootmodule.domain.dto.UserQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;

@Mapper
public interface UserRepository extends BaseMapper<User> {

    /**
     * 根据用户名查询用户
     */
    User findByUsername(@Param("username") String username);

    /**
     * 根据邮箱查询用户
     */
    User findByEmail(@Param("email") String email);

    /**
     * 分页查询用户列表
     */
    IPage<User> selectUserPage(Page<User> page, @Param("query") UserQueryDTO queryDTO);

    /**
     * 更新用户最后登录信息
     */
    int updateLoginInfo(@Param("id") Long id,
                        @Param("loginTime") LocalDateTime loginTime,
                        @Param("loginIp") String loginIp);
}
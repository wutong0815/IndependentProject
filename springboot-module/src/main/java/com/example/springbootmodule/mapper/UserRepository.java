package com.example.springbootmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmodule.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRepository extends BaseMapper<User> {

    IPage<User> selectUserPage(Page<User> page,
                                  @Param("username") String username,
                                  @Param("realName") String realName,
                                  @Param("status") Integer status);

    User findByUsername(@Param("username") String username);

    User findByEmail(@Param("email") String email);

    List<User> findUsersByRoleId(@Param("roleId") Long roleId);
}
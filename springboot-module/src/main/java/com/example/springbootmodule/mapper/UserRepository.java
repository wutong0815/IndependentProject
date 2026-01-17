package com.example.springbootmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmodule.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository extends BaseMapper<User> {

    IPage<User> selectUserPage(Page<User> page,
                                  @Param("username") String username,
                                  @Param("realName") String realName,
                                  @Param("status") Integer status);


    Optional<User> findByUsername(String username);

    Optional<User> findByPhone(String phone);

    User findByEmail(@Param("email") String email);

    List<User> findUsersByRoleId(@Param("roleId") Long roleId);
}
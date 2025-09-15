package com.example.springbootmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmodule.domain.Role;
import com.example.springbootmodule.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleRepository extends BaseMapper<Role> {

    IPage<Role> selectRolePage(Page<Role> page,
                               @Param("roleName") String roleName,
                               @Param("roleCode") String roleCode,
                               @Param("status") Integer status);

    Role findByRoleCode(@Param("roleCode") String roleCode);

    List<Role> findRolesByUserId(@Param("userId") Long userId);
}
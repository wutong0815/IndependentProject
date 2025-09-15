package com.example.springbootmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmodule.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionRepository extends BaseMapper<Permission> {

    List<Permission> findByType(@Param("type") Integer type);

    List<Permission> findByParentId(@Param("parentId") Long parentId);

    List<Permission> findPermissionsByRoleId(@Param("roleId") Long roleId);

    List<Permission> findPermissionsByUserId(@Param("userId") Long userId);
}
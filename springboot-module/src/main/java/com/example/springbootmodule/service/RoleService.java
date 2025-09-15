package com.example.springbootmodule.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmodule.domain.Role;

import java.util.List;

public interface RoleService extends IService<Role> {

    IPage<Role> getRolePage(Integer pageNum, Integer pageSize,
                            String roleName, String roleCode, Integer status);

    Role getByRoleCode(String roleCode);

    boolean createRole(Role role);

    boolean updateRole(Long id, Role role);

    boolean deleteRole(Long id);

    List<Role> getRolesByUserId(Long userId);

    boolean assignPermissionsToRole(Long roleId, List<Long> permissionIds);

    boolean assignRolesToUser(Long userId, List<Long> roleIds);
}
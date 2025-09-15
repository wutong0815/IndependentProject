package com.example.springbootmodule.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmodule.domain.Permission;
import com.example.springbootmodule.mapper.PermissionRepository;
import com.example.springbootmodule.service.PermissionService;
import com.example.springbootmodule.mapper.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl extends PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<GrantedAuthority> getUserPermissions(Long userId) {
        List<Permission> permissions = permissionRepository.findPermissionsByUserId(userId);
        return permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Permission> getPermissionsByRoleId(Long roleId) {
        return permissionRepository.findPermissionsByRoleId(roleId);
    }

    @Override
    public boolean hasPermission(String permissionCode) {
        // 获取当前用户权限并检查
        return true;
    }
}
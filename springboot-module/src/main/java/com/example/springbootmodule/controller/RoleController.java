package com.example.springbootmodule.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootmodule.domain.Role;
import com.example.springbootmodule.service.RoleService;
import com.example.springbootcommon.response.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public Result<IPage<Role>> getRoleList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String roleName,
            @RequestParam(required = false) String roleCode,
            @RequestParam(required = false) Integer status) {

        IPage<Role> page = roleService.getRolePage(pageNum, pageSize, roleName, roleCode, status);
        return Result.success(page);
    }

    @GetMapping("/{id}")
    public Result<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.getById(id);
        return role != null ? Result.success(role) : Result.error("角色不存在");
    }

    @GetMapping("/code/{roleCode}")
    public Result<Role> getRoleByCode(@PathVariable String roleCode) {
        Role role = roleService.getByRoleCode(roleCode);
        return role != null ? Result.success(role) : Result.error("角色不存在");
    }

    @GetMapping("/user/{userId}")
    public Result<List<Role>> getRolesByUserId(@PathVariable Long userId) {
        List<Role> roles = roleService.getRolesByUserId(userId);
        return Result.success(roles);
    }

    @PostMapping
    public Result<Role> createRole(@Valid @RequestBody Role role) {
        boolean success = roleService.createRole(role);
        return success ? Result.success(role) : Result.error("创建角色失败");
    }

    @PutMapping("/{id}")
    public Result<Role> updateRole(@PathVariable Long id, @Valid @RequestBody Role role) {
        boolean success = roleService.updateRole(id, role);
        return success ? Result.success(role) : Result.error("更新角色失败");
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteRole(@PathVariable Long id) {
        boolean success = roleService.deleteRole(id);
        return success ? Result.success() : Result.error("删除角色失败");
    }

    @PostMapping("/{roleId}/permissions")
    public Result<Void> assignPermissions(@PathVariable Long roleId, @RequestBody List<Long> permissionIds) {
        boolean success = roleService.assignPermissionsToRole(roleId, permissionIds);
        return success ? Result.success() : Result.error("分配权限失败");
    }

    @PostMapping("/user/{userId}/roles")
    public Result<Void> assignRolesToUser(@PathVariable Long userId, @RequestBody List<Long> roleIds) {
        boolean success = roleService.assignRolesToUser(userId, roleIds);
        return success ? Result.success() : Result.error("分配角色失败");
    }
}

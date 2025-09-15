package com.example.springbootmodule.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmodule.domain.Role;
import com.example.springbootmodule.mapper.RoleRepository;
import com.example.springbootmodule.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository RoleRepository;

    public RoleServiceImpl(com.example.springbootmodule.mapper.RoleRepository roleRepository) {
        RoleRepository = roleRepository;
    }

    @Override
    public IPage<Role> getRolePage(Integer pageNum, Integer pageSize,
                                   String roleName, String roleCode, Integer status) {
        Page<Role> page = new Page<>(pageNum, pageSize);
        return RoleRepository.selectRolePage(page, roleName, roleCode, status);
    }

    @Override
    public Role getByRoleCode(String roleCode) {
        // 检查角色是否存在
        Role role = RoleRepository.findByRoleCode(roleCode);
        if (role == null) {
            throw new IllegalArgumentException("角色不存在");
        }
        return role;
    }

    @Override
    public boolean createRole(Role role) {
        return save(role);
    }

    @Override
    public boolean updateRole(Long id, Role role) {
        role.setId(id);
        return updateById(role);
    }

    @Override
    public boolean deleteRole(Long id) {
        return removeById(id);
    }

    @Override
    @Transactional
    public boolean assignPermissionsToRole(Long roleId, List<Long> permissionIds) {
        // 这里需要实现权限分配逻辑
        // 先删除原有权限，再添加新权限
        return true;
    }

    @Override
    @Transactional
    public boolean assignRolesToUser(Long userId, List<Long> roleIds) {
        // 这里需要实现角色分配逻辑
        // 先删除原有角色，再添加新角色
        return true;
    }
    @Override
    public List<Role> getRolesByUserId(Long userId) {
        return RoleRepository.findRolesByUserId(userId);
    }

    @Override
    public boolean saveBatch(Collection<Role> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Role> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Role> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Role entity) {
        return false;
    }

    @Override
    public Role getOne(Wrapper<Role> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Optional<Role> getOneOpt(Wrapper<Role> queryWrapper, boolean throwEx) {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Role> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Role> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Role> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Role> getEntityClass() {
        return null;
    }
}
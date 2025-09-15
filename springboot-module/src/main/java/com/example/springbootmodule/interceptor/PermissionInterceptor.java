package com.example.springbootmodule.interceptor;

import com.example.springbootmodule.annotation.RequiresPermissions;
import com.example.springbootmodule.annotation.RequiresRoles;
import com.example.springbootmodule.service.PermissionService;
import com.example.springbootmodule.service.RoleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 检查角色权限
        RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
        if (requiresRoles != null) {
            // 实现角色验证逻辑
        }

        // 检查权限
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if (requiresPermissions != null) {
            // 实现权限验证逻辑
        }

        return true;
    }
}

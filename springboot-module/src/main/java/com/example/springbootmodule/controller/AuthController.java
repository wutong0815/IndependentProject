package com.example.springbootmodule.controller;

import com.example.common.response.Result;
import com.example.medical.entity.SysUser;
import com.example.medical.security.JwtTokenUtil;
import com.example.medical.service.SysUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtTokenUtil.generateToken(userDetails);
        SysUser user = userService.getByUsername(userDetails.getUsername());

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", user);
        result.put("permissions", userDetails.getAuthorities());

        return Result.success(result);
    }

    @PostMapping("/register")
    public Result<SysUser> register(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userService.getByUsername(registerRequest.getUsername()) != null) {
            return Result.error("用户名已存在");
        }

        SysUser user = new SysUser();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setRealName(registerRequest.getRealName());

        boolean success = userService.createUser(user);
        return success ? Result.success(user) : Result.error("注册失败");
    }

    @GetMapping("/user-info")
    public Result<Map<String, Object>> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        SysUser user = userService.getByUsername(username);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("permissions", userDetails.getAuthorities());

        return Result.success(result);
    }

    // DTO类
    public static class LoginRequest {
        private String username;
        private String password;
        // getters and setters
    }

    public static class RegisterRequest {
        private String username;
        private String password;
        private String email;
        private String realName;
        // getters and setters
    }
}

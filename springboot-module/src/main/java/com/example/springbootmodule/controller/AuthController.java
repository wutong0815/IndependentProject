package com.example.springbootmodule.controller;

import com.example.springbootcommon.*;
import com.example.springbootcommon.response.Result;
import com.example.springbootmodule.*;
import com.example.springbootmodule.domain.User;
import com.example.springbootmodule.security.JwtTokenUtil;
import com.example.springbootmodule.security.SsoJwtTokenUtil;
import com.example.springbootmodule.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
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
    private UserService userService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtTokenUtil.generateToken(userDetails);
        User user = userService.getByUsername(userDetails.getUsername());

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", user);
        result.put("permissions", userDetails.getAuthorities());

        return Result.success(result);
    }

    @PostMapping("/register")
    public Result<User> register(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userService.getByUsername(registerRequest.getUsername()) != null) {
            return Result.error("用户名已存在");
        }

        User user = new User();
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

        User user = userService.getByUsername(username);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("permissions", userDetails.getAuthorities());

        return Result.success(result);
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    public static class RegisterRequest {
        private String username;
        private String password;
        private String email;
        private String realName;
        // getters and setters
    }
}

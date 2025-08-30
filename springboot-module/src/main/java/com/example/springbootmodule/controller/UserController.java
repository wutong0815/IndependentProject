package com.example.springbootmodule.controller;

import com.example.springbootcommon.response.Result;
import com.example.springbootmodule.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return Result.success();
    }
}

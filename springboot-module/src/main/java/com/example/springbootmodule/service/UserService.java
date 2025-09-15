package com.example.springbootmodule.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmodule.domain.User;

public interface UserService extends IService<User> {

    IPage<User> getUserPage(Integer pageNum, Integer pageSize,
                               String username, String realName, Integer status);

    User getByUsername(String username);

    boolean createUser(User user);

    boolean updateUser(Long id, User user);

    boolean deleteUser(Long id);

    boolean updateUserStatus(Long id, Integer status);

    boolean resetPassword(Long id, String newPassword);


    String getUserPermissions(Long id);
}

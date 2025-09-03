package com.example.springbootmodule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmodule.domain.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProfileRepository extends BaseMapper<UserProfile> {

    /**
     * 根据用户ID查询详情
     */
    UserProfile findByUserId(@Param("userId") Long userId);
}
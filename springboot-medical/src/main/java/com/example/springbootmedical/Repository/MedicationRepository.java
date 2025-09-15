package com.example.springbootmedical.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmedical.entity.Medication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicationRepository extends BaseMapper<Medication> {


    @Select("select * from medication where id = #{id}")
    Medication findById(Long id);

    @Select("select * from medication where name = #{name}")
    List<Medication> findByName(@Param("name") String name);


    @Select("select * from medication where name like #{name}")
    List<Medication> findByNameLike(@Param("name") String name);

    /**
     * 分页查询药品信息
     * @param page 分页信息
     * @param name 药品名称
     * @param genericName 通用名称
     * @param categoryId 分类ID
     * @param status 状态
     * @return 药品信息列表
     */
    IPage<Medication> selectMedicationPage(Page<Medication> page,
                                           @Param("name") String name,
                                           @Param("genericName") String genericName,
                                           @Param("categoryId") Long categoryId,
                                           @Param("status") Integer status);

    /**
     * 根据名称查询药品信息
     * @param name 药品名称
     * @return 药品信息
     */
    List<Medication> findByName(@Param("name") String name);
}
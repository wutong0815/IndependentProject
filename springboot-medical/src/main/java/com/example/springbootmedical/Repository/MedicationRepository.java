package com.example.springbootmedical.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmedical.entity.Medication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MedicationRepository extends BaseMapper<Medication> {

    IPage<Medication> selectMedicationPage(Page<Medication> page,
                                           @Param("name") String name,
                                           @Param("genericName") String genericName,
                                           @Param("categoryId") Long categoryId,
                                           @Param("status") Integer status);

    Medication findByName(@Param("name") String name);
}
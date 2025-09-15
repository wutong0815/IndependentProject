package com.example.springbootmedical.Service;

import com.example.springbootmedical.entity.Medication;

import java.util.List;

public interface MedicationService {
    /**
     * 查询所有药品信息
     * @return 药品信息列表
     */
    List<Medication> findAll();

    /**
     * 根据ID查询药品信息
     * @param id 药品ID
     * @return 药品信息
     */
    Medication findById(Long id);

    /**
     * 根据名称查询药品信息
     * @param name 药品名称
     * @return 药品信息列表
     */
    List<Medication> findByName(String name);

    List<Medication> findByCategoryId(Long categoryId);
}

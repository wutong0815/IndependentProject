package com.example.springbootmedical.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmedical.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PatientRepository extends BaseMapper<Patient> {

    IPage<Patient> selectPatientPage(Page<Patient> page,
                                     @Param("name") String name,
                                     @Param("medicalRecordNumber") String medicalRecordNumber,
                                     @Param("contactPhone") String contactPhone);

    Patient findByMedicalRecordNumber(@Param("medicalRecordNumber") String medicalRecordNumber);
}
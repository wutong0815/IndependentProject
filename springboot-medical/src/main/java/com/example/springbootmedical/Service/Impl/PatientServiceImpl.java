package com.example.springbootmedical.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmedical.Repository.PatientRepository;
import com.example.springbootmedical.Service.PatientService;
import com.example.springbootmedical.entity.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientRepository, Patient> implements PatientService {

    @Override
    public IPage<Patient> getPatientPage(Integer pageNum, Integer pageSize,
                                         String name, String medicalRecordNumber, String contactPhone) {
        Page<Patient> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPatientPage(page, name, medicalRecordNumber, contactPhone);
    }

    @Override
    public Patient getByMedicalRecordNumber(String medicalRecordNumber) {
        return baseMapper.findByMedicalRecordNumber(medicalRecordNumber);
    }

    @Override
    public boolean createPatient(Patient patient) {
        return save(patient);
    }

    @Override
    public boolean updatePatient(Long id, Patient patient) {
        patient.setId(id);
        return updateById(patient);
    }

    @Override
    public boolean deletePatient(Long id) {
        return removeById(id);
    }
}
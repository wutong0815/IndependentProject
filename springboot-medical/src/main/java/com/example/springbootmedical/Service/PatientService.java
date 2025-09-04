package com.example.springbootmedical.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmedical.entity.Patient;

public interface PatientService extends IService<Patient> {

    IPage<Patient> getPatientPage(Integer pageNum, Integer pageSize,
                                  String name, String medicalRecordNumber, String contactPhone);

    Patient getByMedicalRecordNumber(String medicalRecordNumber);

    boolean createPatient(Patient patient);

    boolean updatePatient(Long id, Patient patient);

    boolean deletePatient(Long id);
}
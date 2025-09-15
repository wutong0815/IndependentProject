package com.example.springbootmedical.Service.Impl;

import com.example.springbootmedical.Service.MedicationService;

import com.example.springbootmedical.Repository.MedicationRepository;
import com.example.springbootmedical.entity.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;
    @Override
    public List<Medication> findAll() {
        return medicationRepository.selectList(null);
    }

    @Override
    public Medication findById(Long id) {
        return medicationRepository.selectById(id);
    }

    @Override
    public List<Medication> findByName(String name) {
        return medicationRepository.findByName(name);
    }

    @Override
    public List<Medication> findByCategoryId(Long categoryId) {
        return medicationRepository.selectMedicationPage(null, null, null, categoryId, null).getRecords();
    }

}

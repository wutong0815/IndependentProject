package com.example.springbootmedical.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootcommon.response.Result;
import com.example.springbootmedical.Service.PatientService;
import com.example.springbootmedical.entity.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public Result<IPage<Patient>> getPatientList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String medicalRecordNumber,
            @RequestParam(required = false) String contactPhone) {

        IPage<Patient> page = patientService.getPatientPage(pageNum, pageSize,
                name, medicalRecordNumber, contactPhone);
        return Result.success(page);
    }

    @GetMapping("/{id}")
    public Result<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getById(id);
        return patient != null ? Result.success(patient) : Result.error("患者不存在");
    }

    @GetMapping("/record-number/{medicalRecordNumber}")
    public Result<Patient> getPatientByRecordNumber(@PathVariable String medicalRecordNumber) {
        Patient patient = patientService.getByMedicalRecordNumber(medicalRecordNumber);
        return patient != null ? Result.success(patient) : Result.error("患者不存在");
    }

    @PostMapping
    public Result<Patient> createPatient(@Valid @RequestBody Patient patient) {
        boolean success = patientService.createPatient(patient);
        return success ? Result.success(patient) : Result.error("创建患者失败");
    }

    @PutMapping("/{id}")
    public Result<Patient> updatePatient(@PathVariable Long id, @Valid @RequestBody Patient patient) {
        boolean success = patientService.updatePatient(id, patient);
        return success ? Result.success(patient) : Result.error("更新患者失败");
    }

    @DeleteMapping("/{id}")
    public Result<Void> deletePatient(@PathVariable Long id) {
        boolean success = patientService.deletePatient(id);
        return success ? Result.success() : Result.error("删除患者失败");
    }
}
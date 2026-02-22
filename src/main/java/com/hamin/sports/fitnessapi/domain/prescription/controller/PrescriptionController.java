package com.hamin.sports.fitnessapi.domain.prescription.controller;

import com.hamin.sports.fitnessapi.domain.prescription.entity.Prescription;
import com.hamin.sports.fitnessapi.domain.prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    // 전체 조회
    @GetMapping
    public List<Prescription> getAll() {
        return prescriptionService.findAll();
    }

    // 생성 (테스트용)
    @PostMapping
    public Prescription create(@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(prescription);
    }
}

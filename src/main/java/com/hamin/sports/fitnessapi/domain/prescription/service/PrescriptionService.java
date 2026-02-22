package com.hamin.sports.fitnessapi.domain.prescription.service;

import com.hamin.sports.fitnessapi.domain.prescription.entity.Prescription;
import com.hamin.sports.fitnessapi.domain.prescription.repository.PrescriptionRepository;
import com.hamin.sports.fitnessapi.domain.userinput.entity.UserInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    // 처방 저장
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // userInput 기반으로 처방 조회
    public Prescription getByUserInput(UserInput userInput) {
        return prescriptionRepository.findByUserInput_Id(userInput.getId());
    }

    // 전체 조회
    public java.util.List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }
}

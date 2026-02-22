package com.hamin.sports.fitnessapi.domain.prescription.repository;

import com.hamin.sports.fitnessapi.domain.prescription.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    boolean existsByUserInput_Id(Long userInputId);

    Prescription findByUserInput_Id(Long userInputId);
}

package com.hamin.sports.fitnessapi.domain.exercisemapping.service;

import com.hamin.sports.fitnessapi.domain.exercisemapping.entity.ExerciseMapping;
import com.hamin.sports.fitnessapi.domain.exercisemapping.repository.ExerciseMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseMappingService {

    private final ExerciseMappingRepository exerciseMappingRepository;

    public ExerciseMapping save(ExerciseMapping mapping) {
        return exerciseMappingRepository.save(mapping);
    }

    public List<ExerciseMapping> getByPrescription(Long prescriptionId) {
        return exerciseMappingRepository.findByPrescription_Id(prescriptionId);
    }

    public List<ExerciseMapping> getAll() {
        return exerciseMappingRepository.findAll();
    }
}

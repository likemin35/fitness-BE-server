package com.hamin.sports.fitnessapi.domain.exercisemapping.repository;

import com.hamin.sports.fitnessapi.domain.exercisemapping.entity.ExerciseMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseMappingRepository extends JpaRepository<ExerciseMapping, Long> {

    List<ExerciseMapping> findByExerciseType(String exerciseType);

    List<ExerciseMapping> findByPrescription_Id(Long prescriptionId);
}
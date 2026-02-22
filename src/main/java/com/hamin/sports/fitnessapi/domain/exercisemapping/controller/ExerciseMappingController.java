package com.hamin.sports.fitnessapi.domain.exercisemapping.controller;

import com.hamin.sports.fitnessapi.domain.exercisemapping.entity.ExerciseMapping;
import com.hamin.sports.fitnessapi.domain.exercisemapping.service.ExerciseMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise-mapping")
@RequiredArgsConstructor
public class ExerciseMappingController {

    private final ExerciseMappingService exerciseMappingService;

    @GetMapping
    public List<ExerciseMapping> getAll() {
        return exerciseMappingService.getAll();
    }

    @GetMapping("/prescription/{id}")
    public List<ExerciseMapping> getByPrescription(@PathVariable Long id) {
        return exerciseMappingService.getByPrescription(id);
    }

    @PostMapping
    public ExerciseMapping create(@RequestBody ExerciseMapping mapping) {
        return exerciseMappingService.save(mapping);
    }
}

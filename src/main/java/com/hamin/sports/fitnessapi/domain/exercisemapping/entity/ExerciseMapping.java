package com.hamin.sports.fitnessapi.domain.exercisemapping.entity;

import com.hamin.sports.fitnessapi.domain.prescription.entity.Prescription;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exerciseType;    // cardio / strength / flexibility
    private String exerciseName;    // 예: “걷기”, “수영”, “벤치프레스”

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}

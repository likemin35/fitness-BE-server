package com.hamin.sports.fitnessapi.domain.prescription.entity;

import com.hamin.sports.fitnessapi.domain.userinput.entity.UserInput;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // UserInput과 1:1 관계 (외래키)
    @OneToOne
    @JoinColumn(name = "user_input_id")
    private UserInput userInput;

    // 원본 텍스트(pres_note 전체)
    @Column(columnDefinition = "TEXT")
    private String rawText;

    // LLM이 분류한 운동 개수
    private Integer cardio;       // 유산소 회수
    private Integer strength;     // 근력 운동 회수
    private Integer flexibility;  // 스트레칭/유연성 회수

    private String createdAt;     // 간단한 버전 (LocalDateTime으로 바꿔도 됨)
}

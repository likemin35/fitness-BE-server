package com.hamin.sports.fitnessapi.domain.recommend.dto;

import lombok.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FitnessRecommendResponse {

    private int step;

    // ★ FastAPI는 리스트임
    private List<Map<String, Object>> similar_users;

    private String pres_note;

    // ★ exercise_recommendation 구조와 완전히 맞춤
    private ExerciseRecommendation exercise_recommendation;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ExerciseRecommendation {
        private List<ExerciseItem> recommended_exercises;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ExerciseItem {
        private String name;
        private String reason;
    }

    // 시설 추천 결과
    private List<FacilityItem> facilities;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FacilityItem {
        private String name;
        private String type;
        private String address;
        private double distanceKm;
    }
}

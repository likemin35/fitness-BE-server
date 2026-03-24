package com.hamin.sports.fitnessapi.domain.recommend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExerciseRecommendation {
        private List<ExerciseItem> recommended_exercises;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FacilityItem {
        private String name;
        @JsonAlias({"type", "category"})
        private String type;
        private String address;
        @JsonAlias({"distanceKm", "distance_km"})
        private double distanceKm;
    }
}

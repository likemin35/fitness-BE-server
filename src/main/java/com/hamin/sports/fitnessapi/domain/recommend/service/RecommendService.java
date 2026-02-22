package com.hamin.sports.fitnessapi.domain.recommend.service;

import com.hamin.sports.fitnessapi.domain.recommend.dto.FacilityRecommendRequest;
import com.hamin.sports.fitnessapi.domain.recommend.dto.FitnessRecommendResponse;
import com.hamin.sports.fitnessapi.domain.userinput.dto.UserInputRequest;
import com.hamin.sports.fitnessapi.global.service.KakaoGeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class RecommendService {

    private final WebClient aiClient = WebClient.create("http://localhost:8000");
    private final KakaoGeocodingService kakaoGeocodingService;

    public FitnessRecommendResponse recommend(
            UserInputRequest userInput,
            FacilityRecommendRequest frontReq,
            String facilityType
    ) {

        // ---------------------------------------
        // 1) RAG + 운동 추천 받기
        // ---------------------------------------
        FitnessRecommendResponse aiResult = aiClient.post()
                .uri("/api/recommend/fitness")
                .bodyValue(userInput)
                .retrieve()
                .bodyToMono(FitnessRecommendResponse.class)
                .block();

        System.out.println("AI_RESULT = " + aiResult);

        // FastAPI 구조: exercise_recommendation.recommended_exercises
        if (aiResult == null ||
                aiResult.getExercise_recommendation() == null ||
                aiResult.getExercise_recommendation().getRecommended_exercises() == null ||
                aiResult.getExercise_recommendation().getRecommended_exercises().isEmpty()) {

            System.out.println("❌ FastAPI 운동 추천 구조와 DTO 매칭 안됨");
            return aiResult;
        }

        // ---------------------------------------
        // 2) 가장 첫 번째 추천 운동 선택
        // ---------------------------------------
        String topExercise =
                aiResult.getExercise_recommendation()
                        .getRecommended_exercises()
                        .get(0)
                        .getName();

        System.out.println("TOP_EXERCISE = " + topExercise);

        // ---------------------------------------
        // 3) 주소 → 좌표 변환
        // ---------------------------------------
        var coord = kakaoGeocodingService.geocode(frontReq.getAddress());
        Double lat = coord.getLat();
        Double lon = coord.getLon();

        // ---------------------------------------
        // 4) AI 서버 시설 추천 요청 DTO 생성
        // ---------------------------------------
        FacilityRecommendRequest facilityReq = FacilityRecommendRequest.builder()
                .address(frontReq.getAddress())
                .facilityType(frontReq.getFacilityType())
                .distanceLimit(frontReq.getDistanceLimit())
                .lat(lat)
                .lon(lon)
                .exerciseName(topExercise)
                .build();

        // ---------------------------------------
        // 5) 시설 추천 API 호출
        // ---------------------------------------
        FitnessRecommendResponse facilityResponse = aiClient.post()
                .uri("/api/recommend/facility")
                .bodyValue(facilityReq)
                .retrieve()
                .bodyToMono(FitnessRecommendResponse.class)
                .block();

        // ---------------------------------------
        // 6) 운동 + 시설 추천 병합
        // ---------------------------------------
        if (facilityResponse != null && facilityResponse.getFacilities() != null) {
            aiResult.setFacilities(facilityResponse.getFacilities());
        }

        return aiResult;
    }
}

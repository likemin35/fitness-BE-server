package com.hamin.sports.fitnessapi.domain.recommend.controller;

import com.hamin.sports.fitnessapi.domain.recommend.dto.FacilityRecommendRequest;
import com.hamin.sports.fitnessapi.domain.recommend.dto.FitnessRecommendRequestWrapper; // ★필수
import com.hamin.sports.fitnessapi.domain.recommend.dto.FitnessRecommendResponse;
import com.hamin.sports.fitnessapi.domain.recommend.service.RecommendService;
import com.hamin.sports.fitnessapi.domain.userinput.dto.UserInputRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;

    @PostMapping("/fitness")
    public FitnessRecommendResponse recommend(
            @RequestBody FitnessRecommendRequestWrapper wrapper,
            @RequestParam(defaultValue = "ALL") String facilityType
    ) {
        return recommendService.recommend(
                wrapper.getUserInput(),
                wrapper.getFacility(),
                facilityType
        );
    }
}

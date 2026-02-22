package com.hamin.sports.fitnessapi.domain.recommend.dto;

import com.hamin.sports.fitnessapi.domain.userinput.dto.UserInputRequest;
import lombok.Data;

@Data
public class FitnessRecommendRequestWrapper {
    private UserInputRequest userInput;
    private FacilityRecommendRequest facility;
}

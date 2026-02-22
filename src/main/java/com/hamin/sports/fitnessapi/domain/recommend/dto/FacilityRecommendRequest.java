package com.hamin.sports.fitnessapi.domain.recommend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacilityRecommendRequest {

    private String address;
    private String facilityType;
    private Integer distanceLimit;

    private Double lat;
    private Double lon;
    private String exerciseName;
}

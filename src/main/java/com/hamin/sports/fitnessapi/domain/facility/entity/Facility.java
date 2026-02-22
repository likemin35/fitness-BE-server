package com.hamin.sports.fitnessapi.domain.facility.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;            // 시설명
    private String address;         // 주소
    private String sido;            // 시/도
    private String sigungu;         // 시군구
    private String category;        // 헬스장/수영장/요가/공공체육시설 등
    private Double latitude;
    private Double longitude;
    private String phone;

    private Boolean couponAvailable;     // 1타3만 쿠폰 여부
    private Boolean sportsVoucher;       // 스포츠강좌이용권
    private String source;               // 공공데이터 API 출처
}

package com.hamin.sports.fitnessapi.global.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KakaoGeocodingService {

    @Value("${kakao.rest.api.key}")
    private String kakaoKey;

    private final WebClient webClient = WebClient.create("https://dapi.kakao.com");

    public GeoCoord geocode(String address) {

        var result = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/local/search/address.json")
                        .queryParam("query", address)
                        .build())
                .header("Authorization", "KakaoAK " + kakaoKey)
                .retrieve()
                .bodyToMono(KakaoResponse.class)
                .block();

        if (result == null || result.documents == null || result.documents.length == 0) {
            return new GeoCoord(null, null);
        }

        KakaoDocument doc = result.documents[0];
        return new GeoCoord(doc.y, doc.x);
    }

    // ---------------------------
    // 반드시 public static class 여야 함!!!
    // ---------------------------
    @Data
    public static class GeoCoord {
        private final Double lat;
        private final Double lon;
    }

    @Data
    static class KakaoResponse {
        KakaoDocument[] documents;
    }

    @Data
    static class KakaoDocument {
        Double x;  // 경도
        Double y;  // 위도
    }
}

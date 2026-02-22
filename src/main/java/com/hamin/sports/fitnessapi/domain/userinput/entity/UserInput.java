package com.hamin.sports.fitnessapi.domain.userinput.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_input")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기본 입력
    private Integer ageClass;
    private String testSex;

    private Double itemF001;
    private Double itemF002;
    private Double itemF003;
    private Double itemF007;
    private Double itemF018;
    private Double itemF015;
    private Double itemF017;
    private Double itemF020;

    // 선택 입력
    private Double itemF004;
    private Double itemF005;
    private Double itemF006;
    private Double itemF008;
    private Double itemF009;
    private Double itemF010;
    private Double itemF012;
    private Double itemF013;
    private Double itemF014;
    private Double itemF016;
    private Double itemF019;
    private Double itemF021;
    private Double itemF022;
    private Double itemF023;
    private Double itemF024;
    private Double itemF025;
    private Double itemF026;
    private Double itemF027;
    private Double itemF028;
    private Double itemF030;
    private Double itemF031;
    private Double itemF032;
    private Double itemF033;
    private Double itemF034;
    private Double itemF035;
    private Double itemF036;
    private Double itemF037;
    private Double itemF038;
    private Double itemF039;
    private Double itemF040;
    private Double itemF041;
    private Double itemF042;
    private Double itemF043;
    private Double itemF044;
    private Double itemF050;
    private Double itemF051;
    private Double itemF052;

    private String testYm;

    private Double lat;
    private Double lon;

    private LocalDateTime createdAt;
}

package com.hamin.sports.fitnessapi.domain.facility.repository;

import com.hamin.sports.fitnessapi.domain.facility.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    List<Facility> findBySidoAndSigungu(String sido, String sigungu);

    List<Facility> findByCategory(String category);
}

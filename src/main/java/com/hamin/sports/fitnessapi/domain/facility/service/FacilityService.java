package com.hamin.sports.fitnessapi.domain.facility.service;

import com.hamin.sports.fitnessapi.domain.facility.entity.Facility;
import com.hamin.sports.fitnessapi.domain.facility.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public Facility save(Facility f) {
        return facilityRepository.save(f);
    }

    public List<Facility> getAll() {
        return facilityRepository.findAll();
    }

    public List<Facility> getByRegion(String sido, String sigungu) {
        return facilityRepository.findBySidoAndSigungu(sido, sigungu);
    }

    public List<Facility> getByCategory(String category) {
        return facilityRepository.findByCategory(category);
    }
}

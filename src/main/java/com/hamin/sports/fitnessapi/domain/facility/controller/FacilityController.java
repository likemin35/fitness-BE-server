package com.hamin.sports.fitnessapi.domain.facility.controller;

import com.hamin.sports.fitnessapi.domain.facility.entity.Facility;
import com.hamin.sports.fitnessapi.domain.facility.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    @GetMapping
    public List<Facility> getAll() {
        return facilityService.getAll();
    }

    @GetMapping("/region")
    public List<Facility> getByRegion(
            @RequestParam String sido,
            @RequestParam String sigungu
    ) {
        return facilityService.getByRegion(sido, sigungu);
    }

    @GetMapping("/category/{category}")
    public List<Facility> getByCategory(@PathVariable String category) {
        return facilityService.getByCategory(category);
    }

    @PostMapping
    public Facility create(@RequestBody Facility f) {
        return facilityService.save(f);
    }
}

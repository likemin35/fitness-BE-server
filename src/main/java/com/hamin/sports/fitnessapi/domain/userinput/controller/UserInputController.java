package com.hamin.sports.fitnessapi.domain.userinput.controller;

import com.hamin.sports.fitnessapi.domain.userinput.dto.UserInputRequest;
import com.hamin.sports.fitnessapi.domain.userinput.service.UserInputService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userinput")
@RequiredArgsConstructor
public class UserInputController {

    private final UserInputService userInputService;

    @PostMapping
    public String save(@RequestBody UserInputRequest request) {
        userInputService.save(request);
        return "saved";
    }
}

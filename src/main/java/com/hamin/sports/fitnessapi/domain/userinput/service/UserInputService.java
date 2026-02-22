package com.hamin.sports.fitnessapi.domain.userinput.service;

import com.hamin.sports.fitnessapi.domain.userinput.dto.UserInputRequest;
import com.hamin.sports.fitnessapi.domain.userinput.entity.UserInput;
import com.hamin.sports.fitnessapi.domain.userinput.repository.UserInputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInputService {

    private final UserInputRepository repository;

    public void save(UserInputRequest request) {

        UserInput entity = UserInput.builder()
                .ageClass(request.getAgeClass())
                .testSex(request.getTestSex())
                .itemF001(request.getItemF001())
                .itemF002(request.getItemF002())
                .itemF003(request.getItemF003())
                .itemF007(request.getItemF007())
                .itemF015(request.getItemF015())
                .itemF017(request.getItemF017())
                .itemF018(request.getItemF018())
                .itemF020(request.getItemF020())
                .createdAt(java.time.LocalDateTime.now())
                .build();

        repository.save(entity);
    }
}

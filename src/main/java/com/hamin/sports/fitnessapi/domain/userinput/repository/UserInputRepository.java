package com.hamin.sports.fitnessapi.domain.userinput.repository;

import com.hamin.sports.fitnessapi.domain.userinput.entity.UserInput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInputRepository extends JpaRepository<UserInput, Long> {
}

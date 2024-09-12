package com.hospital.webapp.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UserRequest(
        @Email
        String email,
        @NotBlank
        String name,
        @Past
        LocalDate birthdate
){
}

package com.hospital.webapp.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClientCreateDTO implements Serializable {

    @NotBlank
    private String identifier;

    @NotBlank
    private LocalDate birthdate;

    @NotBlank
    //enum("male", "female")
    private String gender;

    @JsonProperty("user_id")
    @NotBlank
    private Long userId;

}

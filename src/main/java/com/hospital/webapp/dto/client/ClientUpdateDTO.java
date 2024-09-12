package com.hospital.webapp.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClientUpdateDTO implements Serializable {

    private String address;

    @JsonProperty("history_number")
    private String historyNumber;

    @JsonProperty("medical_history")
    private String medicalHistory;

}

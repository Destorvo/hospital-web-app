package com.hospital.webapp.dto.medic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicCreateDTO{

    @NotBlank
    private String mci;

    @JsonProperty("user_id")
    @NotBlank
    private Long userId;
}

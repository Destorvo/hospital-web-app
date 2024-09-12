package com.hospital.webapp.dto.appointment;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCreateDTO {

        @NotNull
        private Long clientId;

        private Long medicId;

        @NotBlank
        private LocalDate assignedDate;

        @NotBlank
        private String speciality;

        private String notes;
}

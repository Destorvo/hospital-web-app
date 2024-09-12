package com.hospital.webapp.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDTO {
    private String medicName;
    private String specialty;
    private LocalDateTime date;
    private String state;
    private String notes;
}

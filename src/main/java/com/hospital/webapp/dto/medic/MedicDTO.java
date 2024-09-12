package com.hospital.webapp.dto.medic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class MedicDTO implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String mci;
    private String specialties;
}
package com.hospital.webapp.dto.medic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class MedicUpdateDTO implements Serializable {
    private String mci;
    private Integer workShiftId;
}

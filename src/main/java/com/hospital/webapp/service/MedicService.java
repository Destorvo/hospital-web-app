package com.hospital.webapp.service;


import com.hospital.webapp.dto.medic.MedicCreateDTO;
import com.hospital.webapp.dto.medic.MedicDTO;

import com.hospital.webapp.entities.Medic;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface MedicService {

    List<Medic> getMedics();

    Optional<Medic> getMedicById(Long id);

    Optional<MedicDTO> getMedicByMedicCode(String medicCode);

    Medic saveMedic(Medic medic);

    void deleteMedicById(Long id);

}
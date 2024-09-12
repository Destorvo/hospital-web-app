package com.hospital.webapp.dao;

import com.hospital.webapp.dto.medic.MedicDTO;
import com.hospital.webapp.entities.Medic;

import java.util.List;
import java.util.Optional;

public interface MedicDAO {

    List<Medic> findAllMedics();

    Optional<Medic> findMedicById(Long id);

    Optional<MedicDTO> findMedicByMedicCode(String medicCode);

    Medic saveMedic(Medic medic);

    void deleteMedicById(Long id);
}

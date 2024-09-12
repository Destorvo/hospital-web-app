package com.hospital.webapp.service.impl;

import com.hospital.webapp.dao.MedicDAO;
import com.hospital.webapp.dto.medic.MedicCreateDTO;
import com.hospital.webapp.dto.medic.MedicDTO;
import com.hospital.webapp.entities.Medic;
import com.hospital.webapp.service.MedicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicServiceImpl implements MedicService {

    private final MedicDAO medicDAO;

    public MedicServiceImpl(MedicDAO medicDAO) {
        this.medicDAO = medicDAO;
    }

    @Override
    public List<Medic> getMedics() {
        return medicDAO.findAllMedics();
    }

    @Override
    public Optional<Medic> getMedicById(Long id) {
        return medicDAO.findMedicById(id);
    }

    @Override
    public Optional<MedicDTO> getMedicByMedicCode(String medicCode) {
        return medicDAO.findMedicByMedicCode(medicCode);
    }

    @Override
    public Medic saveMedic(Medic medic) {
        return medicDAO.saveMedic(medic);
    }

    @Override
    public void deleteMedicById(Long id) {
        medicDAO.deleteMedicById(id);
    }

}

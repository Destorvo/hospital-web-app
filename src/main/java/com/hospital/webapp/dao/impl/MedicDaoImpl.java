package com.hospital.webapp.dao.impl;

import com.hospital.webapp.dao.MedicDAO;
import com.hospital.webapp.dto.medic.MedicDTO;
import com.hospital.webapp.entities.Medic;
import com.hospital.webapp.repositories.MedicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicDaoImpl implements MedicDAO {

    private final MedicRepository medicRepository;

    public MedicDaoImpl(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public List<Medic> findAllMedics() {
        return medicRepository.findAll();
    }

    @Override
    public Optional<Medic> findMedicById(Long id) {
        return medicRepository.findById(id);
    }

    @Override
    public Optional<MedicDTO> findMedicByMedicCode(String medicCode) {
        List<Object[]> result = medicRepository.findUserAndMedicDetailsByMci(medicCode);

        if (result.isEmpty())
            return Optional.empty();


        Object[] row = result.getFirst();

        if (row.length < 5)
            throw new RuntimeException("Unexpected number of columns in the result set");

        String name = (String) row[0];
        String surname = (String) row[1];
        String email = (String) row[2];
        String mci = (String) row[3];
        String specialtiesNames = (String) row[4];
        return Optional.of(new MedicDTO(name, surname, email, mci, specialtiesNames));
    }


    @Override
    public Medic saveMedic(Medic medic) {
        return medicRepository.save(medic);
    }

    @Override
    public void deleteMedicById(Long id) {
        medicRepository.deleteById(id);
    }
}

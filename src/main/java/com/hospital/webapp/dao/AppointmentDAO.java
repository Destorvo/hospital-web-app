package com.hospital.webapp.dao;

import com.hospital.webapp.entities.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentDAO {

    List<Appointment> findAll();

    List<Appointment> findAllByClientId(Long id);

    List<Appointment> findAllByMedicId(Long id);

    Optional<Appointment> findById(Long id);

    void save(Appointment appointment);

    // void update(Appointment appointment);

    void updateNotes(String notes);

    void deleteById(Long id);
}

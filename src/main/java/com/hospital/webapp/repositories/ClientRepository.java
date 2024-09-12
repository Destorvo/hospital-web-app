package com.hospital.webapp.repositories;

import com.hospital.webapp.dto.appointment.AppointmentCreateDTO;
import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT new com.hospital.webapp.dto.client.ClientDTO(u.name, u.surname, u.email, u.phoneNumber, " +
            "TIMESTAMPDIFF(YEAR, c.birthdate, CURDATE()), c.birthdate, c.gender, c.address, c.identifier, c.historyNumber) " +
            "FROM Client c JOIN c.userClient u")
    List<ClientDTO> findAllUsersAndClientsDetails();

    @Query("SELECT new com.hospital.webapp.dto.client.ClientDTO(u.name, u.surname, u.email, u.phoneNumber, " +
            "TIMESTAMPDIFF(YEAR, c.birthdate, CURDATE()), c.birthdate, c.gender, c.address, c.identifier, c.historyNumber) " +
            "FROM Client c JOIN c.userClient u " +
            "WHERE c.identifier = ?1")
    Optional<ClientDTO> findUserAndClientDetailsByIdentify(String identify);

    @Query("SELECT new com.hospital.webapp.dto.client.ClientDTO(u.name, u.surname, u.email, u.phoneNumber, " +
            "TIMESTAMPDIFF(YEAR, c.birthdate, CURDATE()), c.birthdate, c.gender, c.address, c.identifier, c.historyNumber) " +
            "FROM Client c JOIN c.userClient u " +
            "WHERE c.historyNumber = ?1")
    Optional<ClientDTO> findUserAndClientDetailsByHistoryNumber(String historyNumber);

// TODO CHAT GPT
    @Query("SELECT new com.hospital.webapp.dto.appointment.AppointmentDTO(u.name, u.surname, s.name, a.assignedDate, a.state, a.notes) " +
            "FROM specialties s, user u, appointment a ")
    Optional<AppointmentCreateDTO> findClientAndAppointmentsDetailsById(Long id);
}

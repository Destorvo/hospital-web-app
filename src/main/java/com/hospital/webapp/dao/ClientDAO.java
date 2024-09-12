package com.hospital.webapp.dao;

import com.hospital.webapp.dto.appointment.AppointmentCreateDTO;
import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDAO {

    List<ClientDTO> findAllClients();

    Optional<Client> findClientById(Long id);

    Optional<ClientDTO> findClientByHistoryNumber(String historyNumber);

    Optional<ClientDTO> findClientByIdentify(String identify);

    Optional<AppointmentCreateDTO> findAppointmentById(Long id);

    Client saveClient(Client client);

    void deleteClientById(Long id);
}

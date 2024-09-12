package com.hospital.webapp.service;


import com.hospital.webapp.dto.appointment.AppointmentCreateDTO;
import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientDTO> getClients();

    Optional<Client> getClientById(Long id);

    Optional<ClientDTO> getClientByHistoryNumber(String historyNumber);

    Optional<ClientDTO> getClientByIdentifier(String identify);

    Optional<AppointmentCreateDTO> getAppointmentById(Long id);

    Client saveClient(Client client);

    void deleteClientById(Long id);

}

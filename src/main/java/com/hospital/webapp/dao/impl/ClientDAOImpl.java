package com.hospital.webapp.dao.impl;

import com.hospital.webapp.dao.ClientDAO;
import com.hospital.webapp.dto.appointment.AppointmentCreateDTO;
import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.entities.Client;
import com.hospital.webapp.repositories.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientDAOImpl implements ClientDAO {

    private final ClientRepository clientRepository;

    public ClientDAOImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> findAllClients() {
        return clientRepository.findAllUsersAndClientsDetails();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<ClientDTO> findClientByHistoryNumber(String historyNumber) {
        return clientRepository.findUserAndClientDetailsByHistoryNumber(historyNumber);
    }

    @Override
    public Optional<ClientDTO> findClientByIdentify(String identify) {
        return clientRepository.findUserAndClientDetailsByIdentify(identify);
    }

    @Override
    public Optional<AppointmentCreateDTO> findAppointmentById(Long id) {
        return clientRepository.findClientAndAppointmentsDetailsById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}

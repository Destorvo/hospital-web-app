package com.hospital.webapp.service.impl;

import com.hospital.webapp.dao.ClientDAO;
import com.hospital.webapp.dto.appointment.AppointmentCreateDTO;
import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.entities.Client;
import com.hospital.webapp.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public List<ClientDTO> getClients() {
        return clientDAO.findAllClients();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientDAO.findClientById(id);
    }

    @Override
    public Optional<ClientDTO> getClientByHistoryNumber(String historyNumber) {
        return clientDAO.findClientByHistoryNumber(historyNumber);
    }

    @Override
    public Optional<ClientDTO> getClientByIdentifier(String identify) {
        return clientDAO.findClientByIdentify(identify);
    }

    @Override
    public Optional<AppointmentCreateDTO> getAppointmentById(Long id) {
        return clientDAO.findAppointmentById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientDAO.saveClient(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientDAO.deleteClientById(id);
    }
}

package com.hospital.webapp.controllers;

import com.hospital.webapp.dto.appointment.AppointmentCreateDTO;
import com.hospital.webapp.dto.appointment.AppointmentRequestDTO;
import com.hospital.webapp.dto.client.ClientCreateDTO;
import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.dto.client.ClientUpdateDTO;
import com.hospital.webapp.entities.Client;
import com.hospital.webapp.entities.User;
import com.hospital.webapp.service.ClientService;
import com.hospital.webapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final UserService userService;

    public ClientController(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<ClientDTO> searchClientBy(@RequestParam(value = "history", required = false) String historyNumber,
                                                    @RequestParam(value = "dni", required = false) String identifier) {
        if(historyNumber != null) {
            return clientService.getClientByHistoryNumber(historyNumber)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } else if (identifier != null) {
            return clientService.getClientByIdentifier(identifier)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/save")
    public ResponseEntity<?> createClient(@Valid @RequestBody ClientCreateDTO clientCreateDTO, BindingResult result) {
        if(result.hasErrors())
            return ResponseEntity.badRequest().build();

        User user = userService.getUserById(clientCreateDTO.getUserId()).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        Client newClient = new Client();
        newClient.setIdentifier(clientCreateDTO.getIdentifier());
        newClient.setBirthdate(clientCreateDTO.getBirthdate());
        newClient.setGender(clientCreateDTO.getGender());
        newClient.setUserClient(user);
        clientService.saveClient(newClient);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/identifier/{identifier}")
                .buildAndExpand(clientCreateDTO.getIdentifier())
                .toUri();
        return ResponseEntity.created(location).body(clientCreateDTO);
    }

    // TODO make the appointment request by client

    @GetMapping("{id}/appointments")
    public ResponseEntity<List<AppointmentCreateDTO>> getAppointments(@PathVariable Long id) {
        return clientService.getAppointmentsById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/{id}/appointments")
    public ResponseEntity<?> requestAppointment (@PathVariable Long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        Optional<Client> existentClient = clientService.getClientById(id);
        if (existentClient.isEmpty())
            return ResponseEntity.notFound().build();

        Client client = existentClient.get();
        client.setAddress(clientUpdateDTO.getAddress());
        client.setHistoryNumber(clientUpdateDTO.getHistoryNumber());
        client.setMedicalHistory(clientUpdateDTO.getMedicalHistory());
        clientService.saveClient(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(u -> {
                    clientService.deleteClientById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}




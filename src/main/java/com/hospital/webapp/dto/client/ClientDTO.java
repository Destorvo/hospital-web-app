package com.hospital.webapp.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTO implements Serializable {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Long age;
    private LocalDate birthdate;
    private String gender;
    private String address;
    private String identifier;
    private String historyNumber;

}

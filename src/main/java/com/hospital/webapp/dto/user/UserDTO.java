package com.hospital.webapp.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Byte rolId;

    public UserDTO(String name, String surname, String email, String phoneNumber, Byte rolId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rolId = rolId;
    }

}

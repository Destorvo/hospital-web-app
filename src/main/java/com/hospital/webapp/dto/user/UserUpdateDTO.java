package com.hospital.webapp.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO implements Serializable {

    private String name;
    private String surname;
    private String email;
    private String password;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("rol_id")
    private Byte rolId;

}

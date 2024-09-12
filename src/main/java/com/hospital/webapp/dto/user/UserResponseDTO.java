package com.hospital.webapp.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO implements Serializable {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private String phoneNumber;
        private Byte rolId;
}

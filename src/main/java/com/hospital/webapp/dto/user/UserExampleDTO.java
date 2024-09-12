package com.hospital.webapp.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserExampleDTO {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
}

package com.hospital.webapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @Email(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    //@JsonProperty("rol_id")
    @JsonIgnore
    private Roles role;

    @OneToOne(mappedBy = "userClient")
    @JsonIgnore
    private Client client;

    @OneToOne(mappedBy = "userMedic")
    @JsonIgnore
    private Medic medic;

/*
    @OneToMany(mappedBy = "user")
    private List<Sale> saleList;
*/

    //default role = 2(user)
    public User() {
        this.role = new Roles();
        this.role.setId((byte) 2);
    }

}

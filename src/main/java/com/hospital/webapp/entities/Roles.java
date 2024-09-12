package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@EqualsAndHashCode
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "TINYINT")
    private Byte id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users;

}

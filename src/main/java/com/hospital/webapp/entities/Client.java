package com.hospital.webapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Past
    @Column(nullable = false)
    private LocalDate birthdate;

    // male = M, female = F
    @Column(length = 1, nullable = false)
    private String gender;

    @Column
    private String address;

    @Column
    @NotBlank
    private String identifier;

    @Column(name = "history_number")
    @JsonProperty("history_number")
    private String historyNumber;

    @Column(name = "medical_history")
    @JsonProperty("medical_history")
    private String medicalHistory;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User userClient;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Appointment> appointments;

}

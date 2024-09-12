package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@EqualsAndHashCode
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "medic_id", nullable = false)
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "speciality_id", nullable = false)
    private Specialties speciality;

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column
    private String notes;

    @Column
    private String state;

}

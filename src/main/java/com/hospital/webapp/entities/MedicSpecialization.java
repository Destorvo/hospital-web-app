package com.hospital.webapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medic_specialization")
@Getter
@Setter
@EqualsAndHashCode
public class MedicSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medicSpeciality;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    @JsonIgnore
    private Specialties specializationId;

}

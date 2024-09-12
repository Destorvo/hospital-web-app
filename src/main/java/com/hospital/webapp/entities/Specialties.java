package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "specialties")
@Getter
@Setter
@EqualsAndHashCode
public class Specialties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "TINYINT")
    private Byte id;
    
    @Column
    private String name;
    
    @Column
    private String description;

    @OneToMany(mappedBy = "specializationId")
    Set<MedicSpecialization> medicSpecializations;

    @OneToMany(mappedBy = "speciality")
    private List<Appointment> appointments;

}

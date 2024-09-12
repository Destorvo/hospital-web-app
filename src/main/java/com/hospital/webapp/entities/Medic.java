package com.hospital.webapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "medic")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // professional identification number (medical school identifier)
    @Column(length = 7, nullable = false)
    private String mci;

    @ManyToOne
    @JoinColumn(name = "work_shift_id")
    @JsonProperty("work_shift")
    private WorkShift workShift;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userMedic;

    @OneToMany(mappedBy = "medicSpeciality")
    @JsonIgnore
    private Set<MedicSpecialization> medicSpecializations;

    @OneToMany(mappedBy = "medic")
    private List<Appointment> appointments;

}

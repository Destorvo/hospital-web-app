package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hospital_inventory")
@Getter
@Setter
@EqualsAndHashCode
public class HospitalInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "piece_id")
    private Piece piece;

    @Column
    private Integer stock;

}

package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pharmacy")
@Getter
@Setter
@EqualsAndHashCode
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer stock;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

}

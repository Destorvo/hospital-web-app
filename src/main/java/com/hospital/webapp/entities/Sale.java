/*package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "sale")
@Getter
@Setter
@EqualsAndHashCode
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Product productId;

    @Column
    private int stock;

    @Column
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
*/
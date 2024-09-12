package com.hospital.webapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "work_shift")
@Getter
@Setter
@EqualsAndHashCode
public class WorkShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String days;

    @Column
    private LocalTime start_time;

    @Column
    private LocalTime end_time;

    @Column
    private String section;

}

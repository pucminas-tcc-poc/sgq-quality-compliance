package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "vehicle")
public class VehicleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_vehicle", nullable = false)
    private Long id;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_model")
    private String model;

    @Column(name = "dt_release")
    private LocalDateTime releaseDate;
}

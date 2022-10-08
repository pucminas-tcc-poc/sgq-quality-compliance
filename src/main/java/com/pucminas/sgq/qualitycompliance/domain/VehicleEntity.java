package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "VEHICLE")
public class VehicleEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_VEHICLE", nullable = false)
    private Long id;

    @Column(name = "DES_NAME")
    private String name;

    @Column(name = "DES_MODEL")
    private String model;

    @Column(name = "DT_RELEASE")
    private LocalDateTime releaseDate;
}

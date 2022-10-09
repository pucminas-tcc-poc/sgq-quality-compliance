package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "part")
public class PartEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_part", nullable = false)
    private Long id;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_model")
    private String model;

    @Column(name = "num_serial_number")
    private Long serialNumber;
}

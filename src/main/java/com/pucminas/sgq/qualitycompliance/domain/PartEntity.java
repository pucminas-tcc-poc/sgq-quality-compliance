package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "PART")
public class PartEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PART", nullable = false)
    private Long id;

    @Column(name = "DES_NAME")
    private String name;

    @Column(name = "DES_MODEL")
    private String model;

    @Column(name = "NUM_SERIAL_NUMBER")
    private Long serialNumber;
}

package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "DEPARTAMENT")
public class DepartamentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DEPARTAMENT", nullable = false)
    private Long id;

    @Column(name = "DES_DEPARTAMENT")
    private String DEPARTAMENT;

    @Column(name = "DES_LOCATION")
    private String location;
}

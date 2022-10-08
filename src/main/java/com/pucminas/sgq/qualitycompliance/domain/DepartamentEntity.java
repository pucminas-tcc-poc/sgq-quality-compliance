package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "DEPARTAMENT")
public class DepartamentEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DEPARTAMENT", nullable = false)
    private Long id;

    @Column(name = "DES_DEPARTAMENT")
    private String DEPARTAMENT;

    @Column(name = "DES_LOCATION")
    private String location;
}

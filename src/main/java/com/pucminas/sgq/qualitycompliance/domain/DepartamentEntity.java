package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "departament")
public class DepartamentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_departament", nullable = false)
    private Long id;

    @Column(name = "des_departament")
    private String departament;

    @Column(name = "des_location")
    private String location;
}

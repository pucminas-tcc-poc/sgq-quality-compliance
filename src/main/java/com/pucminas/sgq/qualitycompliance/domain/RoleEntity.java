package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "ROLE")
public class RoleEntity extends BaseEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ROLE", nullable = false)
    private Long id;

    @Column(name = "DES_NAME")
    private String name;
}

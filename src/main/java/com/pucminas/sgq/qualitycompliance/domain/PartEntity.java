package com.pucminas.sgq.qualitycompliance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "part")
public class PartEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_part", nullable = false)
    private Long id;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_model")
    private String model;

    @Column(name = "num_serial_number")
    private Long serialNumber;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}

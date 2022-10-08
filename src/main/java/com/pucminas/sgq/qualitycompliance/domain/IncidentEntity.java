package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "INCIDENT")
public class IncidentEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_INCIDENT", nullable = false)
    private Long id;

    @Column(name = "DES_INCIDENT")
    private String incident;

    @Column(name = "DES_STATUS")
    private IncidentStatus status;

    @Column(name = "DES_TYPE")
    private IncidentType type;

    @Column(name = "DES_PLACE")
    private String place;

    @Column(name = "DES_DEMAGE")
    private String demage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PART")
    private PartEntity part;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICLE")
    private VehicleEntity vehicle;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NON_COMPLIANCE")
    private NonComplianceEntity nonCompliance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private UserEntity responsible;
}

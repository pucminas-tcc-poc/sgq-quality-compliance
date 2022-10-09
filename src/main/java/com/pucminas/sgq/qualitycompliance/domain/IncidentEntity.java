package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "incident")
public class IncidentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_incident", nullable = false)
    private Long id;

    @Column(name = "des_incident")
    private String incident;

    @Column(name = "des_status")
    private IncidentStatus status;

    @Column(name = "des_type")
    private IncidentType type;

    @Column(name = "des_place")
    private String place;

    @Column(name = "des_demage")
    private String demage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_part")
    private PartEntity part;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicle")
    private VehicleEntity vehicle;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_non_compliance")
    private NonComplianceEntity nonCompliance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity responsible;
}

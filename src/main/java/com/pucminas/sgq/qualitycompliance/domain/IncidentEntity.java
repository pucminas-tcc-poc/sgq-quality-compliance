package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
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
@Table(name = "incident")
public class IncidentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incident", nullable = false)
    private Long id;

    @Column(name = "des_incident")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_status")
    private IncidentStatus status;

    @Enumerated(EnumType.STRING)
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

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}

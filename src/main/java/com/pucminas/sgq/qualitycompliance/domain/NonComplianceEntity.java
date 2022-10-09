package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "non_compliance")
public class NonComplianceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_non_compliance", nullable = false)
    private Long id;

    @Column(name = "des_non_compliance")
    private String nonComplianceDescription;

    @Column(name = "des_operational_consequence")
    private String operationalConsequence;

    @Column(name = "des_type")
    @Enumerated(EnumType.STRING)
    private NonComplianceType type;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}

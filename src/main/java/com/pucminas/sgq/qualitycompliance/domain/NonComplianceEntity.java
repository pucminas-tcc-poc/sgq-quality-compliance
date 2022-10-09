package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "non_compliance")
public class NonComplianceEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_non_compliance", nullable = false)
    private Long id;

    @Column(name = "des_non_compliance")
    private String nonComplianceDescription;

    @Column(name = "des_operational_consequence")
    private String operationalConsequence;

    @Column(name = "des_type")
    private NonComplianceType type;
}

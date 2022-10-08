package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "NON_COMPLIANCE")
public class NonComplianceEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_NON_COMPLIANCE", nullable = false)
    private Long id;

    @Column(name = "DES_NON_COMPLIANCE")
    private String nonComplianceDescription;

    @Column(name = "DES_OPERATIONAL_CONSEQUENCE")
    private String operationalConsequence;

    @Column(name = "DES_OPERATIONAL_CONSEQUENCE")
    private NonComplianceType type;
}

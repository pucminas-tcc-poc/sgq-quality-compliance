package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "NON_COMPLIANCE_ACTION")
public class NonComplianceActionEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_NON_COMPLIANCE_ACTION", nullable = false)
    private Long id;

    @Column(name = "DES_IMMEDIATE_ACTION")
    private String immediateAction;

    @Column(name = "DES_FOLLOW_UP_ACTION")
    private String followUpAction;

    @Column(name = "DES_FOLLOW_UP_ACTION")
    private NonComplianceActionStatus status;

    @Column(name = "DT_DUE_DATE")
    private LocalDateTime dueDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NON_COMPLIANCE")
    private NonComplianceEntity nonCompliance;

}

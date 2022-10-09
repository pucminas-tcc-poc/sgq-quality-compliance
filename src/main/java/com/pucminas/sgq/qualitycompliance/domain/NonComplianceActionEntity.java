package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "non_compliance_action")
public class NonComplianceActionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_non_compliance_action", nullable = false)
    private Long id;

    @Column(name = "des_immediate_action")
    private String immediateAction;

    @Column(name = "des_follow_up_action")
    private String followUpAction;

    @Column(name = "des_status")
    private NonComplianceActionStatus status;

    @Column(name = "dt_due_date")
    private LocalDateTime dueDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_non_compliance")
    private NonComplianceEntity nonCompliance;

}

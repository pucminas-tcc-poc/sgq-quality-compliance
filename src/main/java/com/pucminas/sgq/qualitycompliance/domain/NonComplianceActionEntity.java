package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
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
@Table(name = "non_compliance_action")
public class NonComplianceActionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_non_compliance_action", nullable = false)
    private Long id;

    @Column(name = "des_immediate_action")
    private String immediateAction;

    @Column(name = "des_follow_up_action")
    private String followUpAction;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_status")
    private NonComplianceActionStatus status;

    @Column(name = "dt_due_date")
    private LocalDateTime dueDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_non_compliance")
    private NonComplianceEntity nonCompliance;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;

}

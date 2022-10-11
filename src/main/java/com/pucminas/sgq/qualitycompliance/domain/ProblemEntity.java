package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.ProblemType;
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
@Table(name = "problem")
public class ProblemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problem", nullable = false)
    private Long id;

    @Column(name = "des_problem")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_type")
    private ProblemType type;

    @Column(name = "des_demage")
    private String demage;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_part")
    private PartEntity part;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vehicle")
    private VehicleEntity vehicle;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_non_compliance")
    private NonComplianceEntity nonCompliance;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserEntity reporter;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}

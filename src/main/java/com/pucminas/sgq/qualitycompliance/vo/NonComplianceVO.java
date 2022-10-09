package com.pucminas.sgq.qualitycompliance.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class NonComplianceVO {
    String nonCompliance;
    String operationalConsequence;
    String type;
}

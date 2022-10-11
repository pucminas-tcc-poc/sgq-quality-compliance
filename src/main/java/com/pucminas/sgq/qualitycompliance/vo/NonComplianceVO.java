package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class NonComplianceVO {
    String nonCompliance;
    String operationalConsequence;
    NonComplianceType type;
}

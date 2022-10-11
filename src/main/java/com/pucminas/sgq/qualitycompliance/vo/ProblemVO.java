package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.ProblemType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ProblemVO {
    String problem;
    ProblemType type;
    String demage;
    Long partId;
    Long vehicleId;
    Long nonComplianceId;
    Long userId;
}


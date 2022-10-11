package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class NonComplianceActionVO {
    String immediateAction;
    String followUpAction;
    String dueDate;
    NonComplianceActionStatus status;
    Long nonComplianceId;
}

package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class NonComplianceActionVO {
    String immediateAction;
    String followUpAction;
    NonComplianceActionStatus status;
    LocalDateTime dueDate;
    NonComplianceVO nonComplianceVO;
}

package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class IncidentVO {
    String incident;
    IncidentStatus status;
    String place;
    String demage;
    PartVO partVO;
    VehicleVO vehicleVO;
    UserVO userVO;
    NonComplianceVO nonComplianceVO;
}


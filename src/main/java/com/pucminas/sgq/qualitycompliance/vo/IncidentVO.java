package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IncidentVO {
    private String incident;
    private IncidentStatus status;
    private String place;
    private String demage;
    private PartVO partVO;
    private VehicleVO vehicleVO;
    private NonComplianceVO nonComplianceVO;
    private UserVO userVO;
}


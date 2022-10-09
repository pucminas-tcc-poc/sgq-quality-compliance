package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class IncidentVO {
    String incident;
    IncidentStatus status;
    IncidentType type;
    String place;
    String demage;
    Long partId;
    Long vehicleId;
    Long nonComplianceId;
    Long userId;
}


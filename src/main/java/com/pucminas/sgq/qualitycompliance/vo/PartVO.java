package com.pucminas.sgq.qualitycompliance.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class PartVO {
    String name;
    String model;
    Long serialNumber;
}

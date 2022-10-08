package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class BaseEntity {
    @Column(name = "DT_CREATION", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "DT_UPDATE")
    private LocalDateTime updateDate;
}

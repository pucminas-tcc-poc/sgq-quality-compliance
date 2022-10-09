package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class BaseEntity {
    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}

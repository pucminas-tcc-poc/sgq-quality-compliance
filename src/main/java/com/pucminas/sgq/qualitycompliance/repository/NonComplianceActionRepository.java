package com.pucminas.sgq.qualitycompliance.repository;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceActionEntity;
import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonComplianceActionRepository extends JpaRepository<NonComplianceActionEntity, Long> {
    List<NonComplianceActionEntity> findByStatus(NonComplianceActionStatus status);
}

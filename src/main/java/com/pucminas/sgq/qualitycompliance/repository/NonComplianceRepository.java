package com.pucminas.sgq.qualitycompliance.repository;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonComplianceRepository extends JpaRepository<NonComplianceEntity, Long> {
    List<NonComplianceEntity> findByType(NonComplianceType type);
}

package com.pucminas.sgq.qualitycompliance.repository;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonComplianceRepository extends JpaRepository<NonComplianceEntity, Long> {

}

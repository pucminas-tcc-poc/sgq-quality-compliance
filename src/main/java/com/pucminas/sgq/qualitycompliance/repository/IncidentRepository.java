package com.pucminas.sgq.qualitycompliance.repository;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
    List<IncidentEntity> findByStatus(String status);
    List<IncidentEntity> findByType(String type);
}

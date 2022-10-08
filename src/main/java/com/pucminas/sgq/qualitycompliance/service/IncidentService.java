package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
import com.pucminas.sgq.qualitycompliance.repository.IncidentRepository;
import com.pucminas.sgq.qualitycompliance.vo.IncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<IncidentEntity> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public List<IncidentEntity> getAllIncidentsByStatus(IncidentStatus status) {
        return incidentRepository.findByStatus(status.toString());
    }

    public List<IncidentEntity> getAllIncidentsByType(IncidentType type) {
        return incidentRepository.findByType(type.toString());
    }

    public IncidentEntity save(IncidentVO incidentVO) {
        // TODO create entityToVOConverter
//        return incidentRepository.save(incidentEntity);
        return null;
    }

    public void deleteById(Long id) {
        incidentRepository.deleteById(id);
    }

    public void deleteAll() {
        incidentRepository.deleteAll();
    }


}

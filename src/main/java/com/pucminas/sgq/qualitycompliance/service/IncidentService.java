package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.*;
import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
import com.pucminas.sgq.qualitycompliance.repository.IncidentRepository;
import com.pucminas.sgq.qualitycompliance.vo.IncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private NonComplianceService nonComplianceService;

    @Autowired
    private UserService userService;

    @Autowired
    private PartService partService;

    public List<IncidentEntity> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Optional<IncidentEntity> findById(Long id) {
        return incidentRepository.findById(id);
    }

    public List<IncidentEntity> getAllIncidentsByStatus(IncidentStatus status) {
        return incidentRepository.findByStatus(status.toString());
    }

    public List<IncidentEntity> getAllIncidentsByType(IncidentType type) {
        return incidentRepository.findByType(type.toString());
    }

    public IncidentEntity save(IncidentEntity incidentEntity) {
        return incidentRepository.save(incidentEntity);
    }

    public void deleteById(Long id) {
        incidentRepository.deleteById(id);
    }

    public void deleteAll() {
        incidentRepository.deleteAll();
    }

    public IncidentEntity createIncident(IncidentVO incidentVO) {
        IncidentEntity incident = new IncidentEntity();
        incident.setDescription(incidentVO.getIncident());
        incident.setDemage(incidentVO.getDemage());
        incident.setPlace(incidentVO.getPlace());
        incident.setStatus(incidentVO.getStatus());
        incident.setType(incidentVO.getType());
        incident.setCreationDate(LocalDateTime.now());

        if (Objects.nonNull(incidentVO.getPartId())) {
            Optional<PartEntity> partOpt = partService.findById(incidentVO.getPartId());
            if (partOpt.isPresent()) {
                incident.setPart(partOpt.get());
            }
        }

        if (Objects.nonNull(incidentVO.getVehicleId())) {
            Optional<VehicleEntity> vehicleOpt = vehicleService.findById(incidentVO.getVehicleId());
            if (vehicleOpt.isPresent()) {
                incident.setVehicle(vehicleOpt.get());
            }
        }

        if (Objects.nonNull(incidentVO.getNonComplianceId())) {
            Optional<NonComplianceEntity> nonComplianceOpt = nonComplianceService.findById(incidentVO.getNonComplianceId());
            if (nonComplianceOpt.isPresent()) {
                incident.setNonCompliance(nonComplianceOpt.get());
            }
        }

        if (Objects.nonNull(incidentVO.getUserId())) {
            Optional<UserEntity> userOpt = userService.findById(incidentVO.getUserId());
            if (userOpt.isPresent()) {
                incident.setResponsible(userOpt.get());
            }
        }

        return incidentRepository.save(incident);
    }


}

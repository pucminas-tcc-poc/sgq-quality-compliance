package com.pucminas.sgq.qualitycompliance.controller;

import com.pucminas.sgq.qualitycompliance.converter.IncidentConverter;
import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.enums.IncidentType;
import com.pucminas.sgq.qualitycompliance.service.IncidentService;
import com.pucminas.sgq.qualitycompliance.vo.IncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping("/incidents")
    public ResponseEntity<List<IncidentVO>> getAllIncidents() {
        try {
            List<IncidentEntity> incidents = incidentService.getAllIncidents();
            if (CollectionUtils.isEmpty(incidents)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<IncidentVO> incidentVOS = incidents.stream()
                    .map(e -> IncidentConverter.toVO(e))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(incidentVOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/incidents/{status}")
    public ResponseEntity<List<IncidentVO>> getAllIncidentsByStatus(@PathVariable(required = false) IncidentStatus status) {
        try {
            List<IncidentEntity> incidents = incidentService.getAllIncidentsByStatus(status);
            if (CollectionUtils.isEmpty(incidents)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<IncidentVO> incidentVOS = incidents.stream()
                    .map(e -> IncidentConverter.toVO(e))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(incidentVOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/incidents/{type}")
    public ResponseEntity<List<IncidentVO>> getAllIncidentsByType(@PathVariable(required = false) IncidentType type) {
        try {
            List<IncidentEntity> incidents = incidentService.getAllIncidentsByType(type);
            if (CollectionUtils.isEmpty(incidents)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<IncidentVO> incidentVOS = incidents.stream()
                    .map(e -> IncidentConverter.toVO(e))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(incidentVOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/incidents")
    public ResponseEntity<IncidentEntity> createIncident(@RequestBody IncidentVO incidentVO) {
        try {
            IncidentEntity incidentEntity = incidentService.createIncident(incidentVO);
            return new ResponseEntity<>(incidentEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/incidents/{id}")
    public ResponseEntity<IncidentEntity> updateIncident(@PathVariable("id") long id, @RequestBody IncidentVO incidentVO) throws ParseException {
        Optional<IncidentEntity> incidentOpt = incidentService.findById(id);
        if (incidentOpt.isPresent()) {
            IncidentEntity managedIncident = incidentOpt.get();
            IncidentEntity incidentEntity = IncidentConverter.toEntity(incidentVO);
            incidentEntity.setId(managedIncident.getId());
            return new ResponseEntity<>(incidentService.save(incidentEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/incidents/{id}")
    public ResponseEntity<HttpStatus> deleteIncident(@PathVariable("id") long id) {
        try {
            incidentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/incidents")
    public ResponseEntity<HttpStatus> deleteAllIncidents() {
        try {
            incidentService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

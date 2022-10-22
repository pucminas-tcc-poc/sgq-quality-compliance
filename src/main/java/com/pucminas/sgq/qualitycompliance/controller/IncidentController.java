package com.pucminas.sgq.qualitycompliance.controller;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.enums.IncidentStatus;
import com.pucminas.sgq.qualitycompliance.service.IncidentService;
import com.pucminas.sgq.qualitycompliance.vo.IncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compliance/api/v1")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping("/incident/{id}")
    public ResponseEntity<IncidentEntity> getById(@PathVariable("id") long id) {
        try {
            Optional<IncidentEntity> incidentOpt = incidentService.findById(id);
            if (incidentOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(incidentOpt.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/incidents")
    public ResponseEntity<List<IncidentEntity>> getAllIncidents() {
        try {
            List<IncidentEntity> incidents = incidentService.getAllIncidents();
            if (CollectionUtils.isEmpty(incidents)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(incidents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/incidents/{status}")
    public ResponseEntity<List<IncidentEntity>> getAllIncidentsByStatus(@PathVariable("status") IncidentStatus status) {
        try {
            List<IncidentEntity> incidents = incidentService.getAllIncidentsByStatus(status);
            if (CollectionUtils.isEmpty(incidents)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(incidents, HttpStatus.OK);
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
    public ResponseEntity<IncidentEntity> updateIncident(@PathVariable("id") long id, @RequestBody IncidentVO incidentVO) {
        Optional<IncidentEntity> incidentOpt = incidentService.findById(id);
        if (incidentOpt.isPresent()) {
            IncidentEntity incidentEntity = incidentService.updateIncident(incidentOpt.get(), incidentVO);
            return new ResponseEntity<>(incidentEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/incidents/{id}")
    public ResponseEntity<HttpStatus> deleteIncidentById(@PathVariable("id") long id) {
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

package com.pucminas.sgq.qualitycompliance.controller;

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

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

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
    public ResponseEntity<List<IncidentEntity>> getAllIncidentsByStatus(@PathVariable(required = false) IncidentStatus status) {
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

    @GetMapping("/incidents/{type}")
    public ResponseEntity<List<IncidentEntity>> getAllIncidentsByType(@PathVariable(required = false) IncidentType type) {
        try {
            List<IncidentEntity> incidents = incidentService.getAllIncidentsByType(type);
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
            IncidentEntity managedIncident = incidentService.save(incidentVO);
            return new ResponseEntity<>(managedIncident, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/incidents/{id}")
    public ResponseEntity<IncidentEntity> updateIncident(@PathVariable("id") long id, @RequestBody IncidentVO incidentVO) {
        if (true) {
        //        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//        if (tutorialData.isPresent()) {
//            Tutorial _tutorial = tutorialData.get();
//            _tutorial.setTitle(tutorial.getTitle());
//            _tutorial.setDescription(tutorial.getDescription());
//            _tutorial.setPublished(tutorial.isPublished());

            return new ResponseEntity<>(incidentService.save(incidentVO), HttpStatus.OK);
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

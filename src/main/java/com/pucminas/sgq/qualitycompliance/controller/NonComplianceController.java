package com.pucminas.sgq.qualitycompliance.controller;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import com.pucminas.sgq.qualitycompliance.service.NonComplianceService;
import com.pucminas.sgq.qualitycompliance.vo.NonComplianceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compliance/api/v1")
public class NonComplianceController {

    @Autowired
    private NonComplianceService nonComplianceService;

    @GetMapping("/nonCompliance/{id}")
    public ResponseEntity<NonComplianceEntity> getById(@PathVariable("id") long id) {
        try {
            Optional<NonComplianceEntity> nonComplianceOpt = nonComplianceService.findById(id);
            if (nonComplianceOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(nonComplianceOpt.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nonCompliances")
    public ResponseEntity<List<NonComplianceEntity>> getAllNonCompliances() {
        try {
            List<NonComplianceEntity> nonCompliances = nonComplianceService.getAllNonCompliances();
            if (CollectionUtils.isEmpty(nonCompliances)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(nonCompliances, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nonCompliances/{type}")
    public ResponseEntity<List<NonComplianceEntity>> getAllNonCompliancesByType(@PathVariable("type") NonComplianceType type) {
        try {
            List<NonComplianceEntity> incidents = nonComplianceService.getAllNonCompliancesByType(type);
            if (CollectionUtils.isEmpty(incidents)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(incidents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/nonCompliances")
    public ResponseEntity<NonComplianceEntity> createNonCompliance(@RequestBody NonComplianceVO nonComplianceVO) {
        try {
            NonComplianceEntity incidentEntity = nonComplianceService.createNonCompliance(nonComplianceVO);
            return new ResponseEntity<>(incidentEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/nonCompliances/{id}")
    public ResponseEntity<NonComplianceEntity> updateNonCompliance(@PathVariable("id") long id, @RequestBody NonComplianceVO nonComplianceVO) throws ParseException {
        Optional<NonComplianceEntity> nonComplianceOpt = nonComplianceService.findById(id);
        if (nonComplianceOpt.isPresent()) {
            NonComplianceEntity incidentEntity = nonComplianceService.updateNonCompliance(nonComplianceOpt.get(), nonComplianceVO);
            return new ResponseEntity<>(incidentEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/nonCompliances/{id}")
    public ResponseEntity<HttpStatus> deleteNonComplianceById(@PathVariable("id") long id) {
        try {
            nonComplianceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/nonCompliances")
    public ResponseEntity<HttpStatus> deleteAllNonCompliances() {
        try {
            nonComplianceService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

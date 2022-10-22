package com.pucminas.sgq.qualitycompliance.controller;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.domain.NonComplianceActionEntity;
import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import com.pucminas.sgq.qualitycompliance.service.NonComplianceActionService;
import com.pucminas.sgq.qualitycompliance.vo.NonComplianceActionVO;
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
public class NonComplianceActionController {

    @Autowired
    private NonComplianceActionService nonComplianceActionService;

    @GetMapping("/nonComplianceAction/{id}")
    public ResponseEntity<NonComplianceActionEntity> getById(@PathVariable("id") long id) {
        try {
            Optional<NonComplianceActionEntity> nonComplianceActionOpt = nonComplianceActionService.findById(id);
            if (nonComplianceActionOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(nonComplianceActionOpt.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nonComplianceActions")
    public ResponseEntity<List<NonComplianceActionEntity>> getAllNonComplianceActions() {
        try {
            List<NonComplianceActionEntity> nonComplianceActions = nonComplianceActionService.getAllNonComplianceActions();
            if (CollectionUtils.isEmpty(nonComplianceActions)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(nonComplianceActions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nonComplianceActions/{status}")
    public ResponseEntity<List<NonComplianceActionEntity>> getAllNonComplianceActionsByStatus(@PathVariable("status") NonComplianceActionStatus status) {
        try {
            List<NonComplianceActionEntity> nonComplianceActions = nonComplianceActionService.getAllNonComplianceActionsByStatus(status);
            if (CollectionUtils.isEmpty(nonComplianceActions)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(nonComplianceActions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/nonComplianceActions")
    public ResponseEntity<NonComplianceActionEntity> createNonComplianceAction(@RequestBody NonComplianceActionVO nonComplianceActionVO) {
        try {
            NonComplianceActionEntity nonComplianceAction = nonComplianceActionService.createNonComplianceAction(nonComplianceActionVO);
            return new ResponseEntity<>(nonComplianceAction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/nonComplianceActions/{id}")
    public ResponseEntity<NonComplianceActionEntity> updateNonComplianceAction(@PathVariable("id") long id, @RequestBody NonComplianceActionVO nonComplianceVO) throws ParseException {
        Optional<NonComplianceActionEntity> nonComplianceOpt = nonComplianceActionService.findById(id);
        if (nonComplianceOpt.isPresent()) {
            NonComplianceActionEntity incidentEntity = nonComplianceActionService.updateNonComplianceAction(nonComplianceOpt.get(), nonComplianceVO);
            return new ResponseEntity<>(incidentEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/nonComplianceActions/{id}")
    public ResponseEntity<HttpStatus> deleteNonComplianceActionById(@PathVariable("id") long id) {
        try {
            nonComplianceActionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/nonComplianceActions")
    public ResponseEntity<HttpStatus> deleteAllNonComplianceActions() {
        try {
            nonComplianceActionService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceActionEntity;
import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import com.pucminas.sgq.qualitycompliance.enums.NonComplianceActionStatus;
import com.pucminas.sgq.qualitycompliance.repository.NonComplianceActionRepository;
import com.pucminas.sgq.qualitycompliance.vo.NonComplianceActionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NonComplianceActionService {

    @Autowired
    private NonComplianceActionRepository nonComplianceActionRepository;

    @Autowired
    private NonComplianceService nonComplianceService;

    public List<NonComplianceActionEntity> getAllNonComplianceActions() {
        return nonComplianceActionRepository.findAll();
    }

    public Optional<NonComplianceActionEntity> findById(Long id) {
        return nonComplianceActionRepository.findById(id);
    }

    public List<NonComplianceActionEntity> getAllNonComplianceActionsByStatus(NonComplianceActionStatus status) {
        return nonComplianceActionRepository.findByStatus(status);
    }

    public NonComplianceActionEntity save(NonComplianceActionEntity incidentEntity) {
        return nonComplianceActionRepository.save(incidentEntity);
    }

    public void deleteById(Long id) {
        nonComplianceActionRepository.deleteById(id);
    }

    public void deleteAll() {
        nonComplianceActionRepository.deleteAll();
    }

    public NonComplianceActionEntity createNonComplianceAction(NonComplianceActionVO nonComplianceActionVO) {
        NonComplianceActionEntity nonComplianceActionEntity = new NonComplianceActionEntity();
        return setupNonComplianceAction(nonComplianceActionEntity, nonComplianceActionVO);
    }

    public NonComplianceActionEntity updateNonComplianceAction(NonComplianceActionEntity incident, NonComplianceActionVO incidentVO) {
        return setupNonComplianceAction(incident, incidentVO);
    }

    private NonComplianceActionEntity setupNonComplianceAction(NonComplianceActionEntity nonComplianceActionEntity, NonComplianceActionVO nonComplianceActionVO) {
        if (Objects.nonNull(nonComplianceActionVO.getImmediateAction())) {
            nonComplianceActionEntity.setImmediateAction(nonComplianceActionVO.getImmediateAction());
        }

        if (Objects.nonNull(nonComplianceActionVO.getFollowUpAction())) {
            nonComplianceActionEntity.setFollowUpAction(nonComplianceActionVO.getFollowUpAction());
        }

        if (Objects.nonNull(nonComplianceActionVO.getStatus())) {
            nonComplianceActionEntity.setStatus(nonComplianceActionVO.getStatus());
        }

        if (Objects.nonNull(nonComplianceActionVO.getDueDate())) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dueDate = LocalDateTime.parse(nonComplianceActionVO.getDueDate(), formatter);
            nonComplianceActionEntity.setDueDate(dueDate);
        }

        if (Objects.isNull(nonComplianceActionEntity.getCreationDate())) {
            nonComplianceActionEntity.setCreationDate(LocalDateTime.now());
        } else {
            nonComplianceActionEntity.setUpdateDate(LocalDateTime.now());
        }

        if (Objects.nonNull(nonComplianceActionVO.getNonComplianceId())) {
            Optional<NonComplianceEntity> nonComplianceOpt = nonComplianceService.findById(nonComplianceActionVO.getNonComplianceId());
            if (nonComplianceOpt.isPresent()) {
                nonComplianceActionEntity.setNonCompliance(nonComplianceOpt.get());
            }
        }

        return nonComplianceActionRepository.save(nonComplianceActionEntity);
    }

}

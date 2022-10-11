package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import com.pucminas.sgq.qualitycompliance.enums.NonComplianceType;
import com.pucminas.sgq.qualitycompliance.repository.NonComplianceRepository;
import com.pucminas.sgq.qualitycompliance.vo.NonComplianceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NonComplianceService {

    @Autowired
    private NonComplianceRepository nonComplianceRepository;

    public Optional<NonComplianceEntity> findById(Long id) {
        return nonComplianceRepository.findById(id);
    }

    public void deleteAll() {
        nonComplianceRepository.deleteAll();
    }

    public void deleteById(Long id) {
        nonComplianceRepository.deleteById(id);
    }

    public List<NonComplianceEntity> getAllNonCompliances() {
        return nonComplianceRepository.findAll();
    }

    public List<NonComplianceEntity> getAllNonCompliancesByType(NonComplianceType type) {
        return nonComplianceRepository.findByType(type);
    }

    public NonComplianceEntity createNonCompliance(NonComplianceVO nonComplianceVO) {
        NonComplianceEntity nonComplianceEntity = new NonComplianceEntity();
        return setupNonCompliance(nonComplianceEntity, nonComplianceVO);
    }

    public NonComplianceEntity updateNonCompliance(NonComplianceEntity nonComplianceEntity, NonComplianceVO nonComplianceVO) {
        return setupNonCompliance(nonComplianceEntity, nonComplianceVO);
    }

    private NonComplianceEntity setupNonCompliance(NonComplianceEntity nonCompliance, NonComplianceVO nonComplianceVO) {
        if (Objects.nonNull(nonComplianceVO.getNonCompliance())) {
            nonCompliance.setDescription(nonComplianceVO.getNonCompliance());
        }

        if (Objects.nonNull(nonComplianceVO.getOperationalConsequence())) {
            nonCompliance.setOperationalConsequence(nonComplianceVO.getOperationalConsequence());
        }

        if (Objects.nonNull(nonComplianceVO.getType())) {
            nonCompliance.setType(nonComplianceVO.getType());
        }

        if (Objects.isNull(nonCompliance.getCreationDate())) {
            nonCompliance.setCreationDate(LocalDateTime.now());
        } else {
            nonCompliance.setUpdateDate(LocalDateTime.now());
        }

        return nonComplianceRepository.save(nonCompliance);
    }

}

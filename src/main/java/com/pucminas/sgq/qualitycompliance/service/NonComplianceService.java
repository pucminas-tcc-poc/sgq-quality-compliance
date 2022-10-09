package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.NonComplianceEntity;
import com.pucminas.sgq.qualitycompliance.repository.NonComplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NonComplianceService {

    @Autowired
    private NonComplianceRepository nonComplianceRepository;

    public Optional<NonComplianceEntity> findById(Long id) {
        return nonComplianceRepository.findById(id);
    }

    public NonComplianceEntity save(NonComplianceEntity nonComplianceEntity) {
        return nonComplianceRepository.save(nonComplianceEntity);
    }

}

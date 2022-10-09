package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.PartEntity;
import com.pucminas.sgq.qualitycompliance.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    public Optional<PartEntity> findById(Long id) {
        return partRepository.findById(id);
    }

    public PartEntity save(PartEntity partEntity) {
        return partRepository.save(partEntity);
    }

}

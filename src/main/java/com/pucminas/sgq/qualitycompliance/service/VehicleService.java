package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.VehicleEntity;
import com.pucminas.sgq.qualitycompliance.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Optional<VehicleEntity> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    public VehicleEntity save(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

}

package com.pucminas.sgq.qualitycompliance.service;

import com.pucminas.sgq.qualitycompliance.domain.*;
import com.pucminas.sgq.qualitycompliance.enums.ProblemType;
import com.pucminas.sgq.qualitycompliance.repository.ProblemRepository;
import com.pucminas.sgq.qualitycompliance.vo.ProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private NonComplianceService nonComplianceService;

    @Autowired
    private UserService userService;

    @Autowired
    private PartService partService;

    public List<ProblemEntity> getAllProblems() {
        return problemRepository.findAll();
    }

    public Optional<ProblemEntity> findById(Long id) {
        return problemRepository.findById(id);
    }

    public List<ProblemEntity> getAllProblemsByType(ProblemType type) {
        return problemRepository.findByType(type);
    }

    public ProblemEntity save(ProblemEntity problemEntity) {
        return problemRepository.save(problemEntity);
    }

    public void deleteById(Long id) {
        problemRepository.deleteById(id);
    }

    public void deleteAll() {
        problemRepository.deleteAll();
    }

    public ProblemEntity createProblem(ProblemVO problemVO) {
        ProblemEntity problem = new ProblemEntity();
        return setupProblem(problem, problemVO);
    }

    public ProblemEntity updateProblem(ProblemEntity problem, ProblemVO problemVO) {
        return setupProblem(problem, problemVO);
    }

    private ProblemEntity setupProblem(ProblemEntity problem, ProblemVO problemVO) {
        if (Objects.nonNull(problemVO.getProblem())) {
            problem.setDescription(problemVO.getProblem());
        }

        if (Objects.nonNull(problemVO.getDemage())) {
            problem.setDemage(problemVO.getDemage());
        }

        if (Objects.nonNull(problemVO.getType())) {
            problem.setType(problemVO.getType());
        }

        if (Objects.isNull(problem.getCreationDate())) {
            problem.setCreationDate(LocalDateTime.now());
        } else {
            problem.setUpdateDate(LocalDateTime.now());
        }

        if (Objects.nonNull(problemVO.getPartId())) {
            Optional<PartEntity> partOpt = partService.findById(problemVO.getPartId());
            if (partOpt.isPresent()) {
                problem.setPart(partOpt.get());
            }
        }

        if (Objects.nonNull(problemVO.getVehicleId())) {
            Optional<VehicleEntity> vehicleOpt = vehicleService.findById(problemVO.getVehicleId());
            if (vehicleOpt.isPresent()) {
                problem.setVehicle(vehicleOpt.get());
            }
        }

        if (Objects.nonNull(problemVO.getNonComplianceId())) {
            Optional<NonComplianceEntity> nonComplianceOpt = nonComplianceService.findById(problemVO.getNonComplianceId());
            if (nonComplianceOpt.isPresent()) {
                problem.setNonCompliance(nonComplianceOpt.get());
            }
        }

        if (Objects.nonNull(problemVO.getUserId())) {
            Optional<UserEntity> userOpt = userService.findById(problemVO.getUserId());
            if (userOpt.isPresent()) {
                problem.setReporter(userOpt.get());
            }
        }

        return problemRepository.save(problem);
    }

}

package com.pucminas.sgq.qualitycompliance.controller;

import com.pucminas.sgq.qualitycompliance.domain.IncidentEntity;
import com.pucminas.sgq.qualitycompliance.domain.ProblemEntity;
import com.pucminas.sgq.qualitycompliance.enums.ProblemType;
import com.pucminas.sgq.qualitycompliance.service.ProblemService;
import com.pucminas.sgq.qualitycompliance.vo.ProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compliance/api/v1")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/problem/{id}")
    public ResponseEntity<ProblemEntity> getById(@PathVariable("id") long id) {
        try {
            Optional<ProblemEntity> problemOpt = problemService.findById(id);
            if (problemOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(problemOpt.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/problems")
    public ResponseEntity<List<ProblemEntity>> getAllProblems() {
        try {
            List<ProblemEntity> problems = problemService.getAllProblems();
            if (CollectionUtils.isEmpty(problems)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(problems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/problems/{type}")
    public ResponseEntity<List<ProblemEntity>> getAllProblemsByType(@PathVariable("type") ProblemType type) {
        try {
            List<ProblemEntity> problems = problemService.getAllProblemsByType(type);
            if (CollectionUtils.isEmpty(problems)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(problems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/problems")
    public ResponseEntity<ProblemEntity> createProblem(@RequestBody ProblemVO problemVO) {
        try {
            ProblemEntity problemEntity = problemService.createProblem(problemVO);
            return new ResponseEntity<>(problemEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/problems/{id}")
    public ResponseEntity<ProblemEntity> updateProblem(@PathVariable("id") long id, @RequestBody ProblemVO problemVO) {
        Optional<ProblemEntity> problemOpt = problemService.findById(id);
        if (problemOpt.isPresent()) {
            ProblemEntity problemEntity = problemService.updateProblem(problemOpt.get(), problemVO);
            return new ResponseEntity<>(problemEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/problems/{id}")
    public ResponseEntity<HttpStatus> deleteProblemById(@PathVariable("id") long id) {
        try {
            problemService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/problems")
    public ResponseEntity<HttpStatus> deleteAllProblems() {
        try {
            problemService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

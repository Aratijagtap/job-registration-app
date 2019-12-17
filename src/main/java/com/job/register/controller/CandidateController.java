package com.job.register.controller;

import java.util.List;
import javax.validation.Valid;

import com.job.register.dto.response.CandidateResponse;
import com.job.register.dto.resquest.CandidateRequest;
import com.job.register.entities.Candidate;
import com.job.register.exception.CandidateAlreadyExistException;
import com.job.register.exception.CandidateNotFoundException;
import com.job.register.exception.ExamNotFoundException;
import com.job.register.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

   private static final Logger log = LoggerFactory.getLogger(CandidateController.class);

   @Autowired
   CandidateService candidateService;

   @GetMapping()
   public List<Candidate> getCandidates() {
      return candidateService.getAllCandidates();
   }

   @GetMapping("/{id}")
   public CandidateResponse getCandidate(@PathVariable int id) throws CandidateNotFoundException {
      log.debug("CandidateController:getCandidate method started");
      try {
         CandidateResponse candidateResponse = candidateService.getCandidate(id);
         log.debug("CandidateController:getCandidate method finished successfully");
         return candidateResponse;
      } catch (CandidateNotFoundException e) {
         log.error("CandidateController:getCandidate method finished with error {}", e);
         throw e;
      }
   }

   @PostMapping()
   public String addCandidate(@RequestBody @Valid CandidateRequest candidateRequest)
         throws ExamNotFoundException, CandidateAlreadyExistException {
      log.debug("CandidateController:addCandidate method started");
      try {
         CandidateResponse candidateResponse = candidateService.addCandidate(candidateRequest);
         log.debug("CandidateController:addCandidate method finished successfully");
         return "Candidate with id " + candidateResponse.getId() + " added successfully.";
      } catch (ExamNotFoundException e) {
         log.debug("CandidateController:addCandidate method finished with ExamNotFoundException {}", e);
         throw e;
      } catch (CandidateAlreadyExistException e) {
         log.debug("CandidateController:addCandidate method finished with CandidateAlreadyExistException {}", e);
         throw e;
      }

   }
}

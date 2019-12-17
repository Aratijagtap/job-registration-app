package com.job.register.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.job.register.dao.CandidateRepository;
import com.job.register.dao.ExamRepository;
import com.job.register.dto.response.CandidateResponse;
import com.job.register.dto.resquest.CandidateRequest;
import com.job.register.entities.Candidate;
import com.job.register.entities.Exam;
import com.job.register.exception.CandidateAlreadyExistException;
import com.job.register.exception.CandidateNotFoundException;
import com.job.register.exception.ExamNotFoundException;
import com.job.register.service.CandidateService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

   private static final Logger log = LoggerFactory.getLogger(CandidateServiceImpl.class);

   @Autowired
   CandidateRepository candidateRepository;

   @Autowired
   ExamRepository examRepository;

   @Override
   public List<Candidate> getAllCandidates() {
      log.debug("List of Candidates");
      return candidateRepository.findAll();
   }

   @Override
   public CandidateResponse getCandidate(int id) throws CandidateNotFoundException {
      log.debug("Get Candidates by id : {}.", id);
      return createCandidateResponse(
            candidateRepository.findById(id).orElseThrow(() -> new CandidateNotFoundException("Candidate not found.")));
   }

   @Override
   public CandidateResponse addCandidate(CandidateRequest candidateRequest)
         throws ExamNotFoundException, CandidateAlreadyExistException {
      log.debug("Adding Candidates");
      Candidate candidate = getCandidateEntity(candidateRequest);
      try {
         Candidate c = candidateRepository.save(candidate);
         log.debug("Candidates added successfully");
         return createCandidateResponse(c);
      } catch (ConstraintViolationException | DuplicateKeyException e) {
         log.error("Candidates already exist");
         throw new CandidateAlreadyExistException("Candidate already exists.");
      }
   }

   private Candidate getCandidateEntity(CandidateRequest candidateRequest) throws ExamNotFoundException {
      Candidate candidate = new Candidate();
      candidate.setName(candidateRequest.getName());
      candidate.setQualification(candidateRequest.getQualification());
      candidate.setExperience(candidateRequest.getExperience());
      log.debug("Creating candidate entity from candidateRequest.");
      candidate.setSkills(candidateRequest.getSkills());

      ArrayList<Exam> examList = new ArrayList<>();
      ArrayList<String> examNames = candidateRequest.getExams();
      for (String e : examNames) {
         Exam exam = examRepository.findByPosition(e);
         if (exam != null) {
            examList.add(exam);
         } else {
            log.error("Exam {} not found in record.", e);
            throw new ExamNotFoundException("Exam " + e + " not found in record.");
         }
      }
      candidate.setExams(examList);
      return candidate;
   }

   private CandidateResponse createCandidateResponse(Candidate candidate) {
      CandidateResponse candidateResponse = new CandidateResponse();
      candidateResponse.setId(candidate.getId());
      candidateResponse.setName(candidate.getName());
      candidateResponse.setQualification(candidate.getQualification());
      candidateResponse.setExperience(candidate.getExperience());
      candidateResponse.setSkills(candidate.getSkills());
      candidateResponse.setExams(candidate.getExams());
      return candidateResponse;
   }
}
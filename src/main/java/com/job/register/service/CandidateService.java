package com.job.register.service;

import java.util.List;

import com.job.register.dto.response.CandidateResponse;
import com.job.register.dto.resquest.CandidateRequest;
import com.job.register.entities.Candidate;
import com.job.register.exception.CandidateAlreadyExistException;
import com.job.register.exception.CandidateNotFoundException;
import com.job.register.exception.ExamNotFoundException;

public interface CandidateService {

   List<Candidate> getAllCandidates();
   CandidateResponse getCandidate(int id) throws CandidateNotFoundException;
   CandidateResponse addCandidate(CandidateRequest candidateRequest) throws ExamNotFoundException,
         CandidateAlreadyExistException;
}

package com.job.register.service.impl;

import java.util.List;

import com.job.register.dao.ExamRepository;
import com.job.register.dto.response.ExamResponse;
import com.job.register.dto.resquest.ExamRequest;
import com.job.register.entities.Exam;
import com.job.register.exception.ExamAlreadyExistException;
import com.job.register.exception.ExamNotFoundException;
import com.job.register.service.ExamService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

   private static final Logger log = LoggerFactory.getLogger(ExamServiceImpl.class);

   @Autowired
   ExamRepository examRepository;

   @Override
   public List<Exam> getAllExams() {
      log.debug("List of Exams");
      return examRepository.findAll();
   }

   @Override
   public ExamResponse getExam(int id) throws ExamNotFoundException {
      log.debug("Get exams by id : {}.", id);
      return getExamResponse(examRepository.findById(id).orElseThrow(()->new ExamNotFoundException("Exam not found.")));
   }

   @Override
   public ExamResponse addExam(ExamRequest examRequest) throws ExamAlreadyExistException {
      log.debug("Adding exam");
      try {
         Exam exam = new Exam();
         exam.setPosition(examRequest.getPosition());
         exam.setDate(examRequest.getDate());
         Exam e = examRepository.save(exam);
         log.debug("Exam added successfully");
         return getExamResponse(e);
      } catch (DataIntegrityViolationException | ConstraintViolationException e) {
         log.error("Exam already exist");
         throw new ExamAlreadyExistException("Exam already exists.");
      }
   }

   private ExamResponse getExamResponse(Exam exam){
      ExamResponse examResponse = new ExamResponse();
      examResponse.setId(exam.getId());
      examResponse.setPosition(exam.getPosition());
      examResponse.setDate(exam.getDate());
      return examResponse;
   }

}

package com.job.register.controller;

import java.util.List;
import javax.validation.Valid;

import com.job.register.dto.response.ExamResponse;
import com.job.register.dto.resquest.ExamRequest;
import com.job.register.entities.Exam;
import com.job.register.exception.ExamAlreadyExistException;
import com.job.register.exception.ExamNotFoundException;
import com.job.register.service.ExamService;
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
@RequestMapping("/api/exam")
public class ExamController {

   private static final Logger log = LoggerFactory.getLogger(ExamController.class);

   @Autowired
   ExamService examService;

   @GetMapping()
   public List<Exam> getExams() {
      return examService.getAllExams();
   }

   @GetMapping("/{id}")
   public ExamResponse getExam(@PathVariable int id) throws ExamNotFoundException {
      log.debug("ExamController:getExam method started");
      try {
         ExamResponse examResponse = examService.getExam(id);
         log.debug("ExamController:getExam method finished successfully");
         return examResponse;
      } catch (ExamNotFoundException e) {
         log.error("ExamController:getExam method finished with ExamNotFoundException {}", e);
         throw e;
      }
   }

   @PostMapping()
   public String addExam(@RequestBody @Valid ExamRequest examRequest) throws ExamAlreadyExistException {
      log.debug("ExamController:addExam method started");
      try {
         ExamResponse examResponse = examService.addExam(examRequest);
         log.debug("ExamController:addExam method finished successfully");
         return "Exam with id " + examResponse.getId() + " added successfully.";
      } catch (ExamAlreadyExistException e) {
         log.error("ExamController:addExam method finished with ExamAlreadyExistException {}", e);
         throw e;
      }
   }
}

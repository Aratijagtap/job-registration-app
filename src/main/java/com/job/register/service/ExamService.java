package com.job.register.service;

import java.util.List;

import com.job.register.dto.response.ExamResponse;
import com.job.register.dto.resquest.ExamRequest;
import com.job.register.entities.Exam;
import com.job.register.exception.ExamAlreadyExistException;
import com.job.register.exception.ExamNotFoundException;

public interface ExamService {

   List<Exam> getAllExams();
   ExamResponse getExam(int id) throws ExamNotFoundException;
   ExamResponse addExam(ExamRequest examRequest) throws ExamAlreadyExistException;

}

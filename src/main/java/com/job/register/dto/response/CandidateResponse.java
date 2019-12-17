package com.job.register.dto.response;

import java.util.List;

import com.job.register.entities.Exam;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Validated
public class CandidateResponse {
   private int id;
   private String name;
   private String qualification;
   private String skills;
   private String experience;
   private List<Exam> exams;
}

package com.job.register.dto.resquest;

import java.io.Serializable;
import java.util.ArrayList;
import javax.validation.constraints.NotEmpty;

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
public class CandidateRequest implements Serializable {
   private static final long serialVersionUID = 7283345531836179693L;

   @NotEmpty(message = "Candidate name should not be null or empty")
   private String name;
   @NotEmpty(message = "Candidate qualification should not be null or empty")
   private String qualification;
   @NotEmpty(message = "Candidate skills should not be null or empty")
   private String skills;
   @NotEmpty(message = "Candidate experience should not be null or empty")
   private String experience;
   @NotEmpty(message = "Exam name should not be null or empty")
   private ArrayList<String> exams;

}

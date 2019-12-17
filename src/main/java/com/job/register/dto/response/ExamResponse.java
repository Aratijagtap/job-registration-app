package com.job.register.dto.response;

import java.io.Serializable;
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
public class ExamResponse {
   private int id;
   private String position;
   private String date;
}

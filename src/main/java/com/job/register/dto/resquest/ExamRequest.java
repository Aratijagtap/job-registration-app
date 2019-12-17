package com.job.register.dto.resquest;

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
public class ExamRequest implements Serializable {
   private static final long serialVersionUID = 7283345531836179693L;

   @NotEmpty(message = "position should not be null or empty")
   private String position;
   @NotEmpty(message = "exam date should not be null or empty")
   private String date;
}

package com.job.register.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "exam", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
@AllArgsConstructor
@NoArgsConstructor
public class Exam implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @NotNull
   @Column(unique = true)
   private String position;
   private String date;
}

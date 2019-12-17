package com.job.register.exception;

public class CandidateAlreadyExistException extends Exception {

   public CandidateAlreadyExistException() {
      super();
   }

   public CandidateAlreadyExistException(String message) {
      super(message);
   }

}

package com.bluebank.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConstraintException extends Exception{
  
  private static final long serialVersionUID = 1L;

  public ConstraintException(String message) {
    super(message);
  }

  public ConstraintException(String message, Throwable cause) {
    super(message, cause);
  }

}

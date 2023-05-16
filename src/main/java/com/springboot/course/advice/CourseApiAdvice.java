package com.springboot.course.advice;

import com.springboot.course.common.ErrorMessage;
import com.springboot.course.exception.NoSuchItemfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseApiAdvice {

    @ExceptionHandler(value = NoSuchItemfoundException.class)
    public ResponseEntity<ErrorMessage> exception(NoSuchItemfoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getErrorMessage());
    }


}

package com.springboot.course.exception;

import com.springboot.course.common.ErrorMessage;

public class NoSuchItemfoundException extends RuntimeException {
   // private static final long serialVersionUID = 1L;
    private ErrorMessage errorMessage;

    public NoSuchItemfoundException() {}

    public NoSuchItemfoundException(String message) {
        super(message);
    }

    public NoSuchItemfoundException(String message, ErrorMessage errorMessage) {
        super(message);
        this.errorMessage=errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}

package com.test.appointmentapp.soapservice.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String e) { super(e); }
}
package com.test.appointmentapp.restservice.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String e) { super(e); }
}

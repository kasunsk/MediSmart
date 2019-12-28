package com.company.medismart.core.exception;

public class ServiceRuntimeException extends RuntimeException {

    private String message;
    private Throwable cause;
    private String errorCode;

    public ServiceRuntimeException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public ServiceRuntimeException(String message, String errorCode, Throwable  cause) {
        this.message = message;
        this.errorCode = errorCode;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

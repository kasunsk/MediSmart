package com.company.medismart.channel.interceptor;


import com.company.medismart.core.exception.ServiceRuntimeException;
import com.company.medismart.core.exception.dto.ApiError;
import com.company.medismart.core.exception.dto.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ServiceRuntimeException.class)
    protected ResponseEntity<Object> applicationException(ServiceRuntimeException ex) {

        ApiError apiError;
        String errorCode = ex.getErrorCode();
        LOG.error(ex.getMessage());


        switch (errorCode) {
            case ErrorCode.AUTH_ERROR:
                apiError = new ApiError(HttpStatus.UNAUTHORIZED);
                apiError.setMessage(ex.getMessage());
                break;
            case ErrorCode.EMPTY_REQUEST:
            case ErrorCode.INSUFFICIENT_DATA:
            case ErrorCode.INVALID_INPUT:
                apiError = new ApiError(HttpStatus.BAD_REQUEST);
                apiError.setMessage(ex.getMessage());
                break;
            case ErrorCode.NOT_FOUND:
                apiError = new ApiError(HttpStatus.NOT_FOUND);
                apiError.setMessage(ex.getMessage());
                break;
            case ErrorCode.ALREADY_EXIST:
                apiError = new ApiError(HttpStatus.ALREADY_REPORTED);
                apiError.setMessage(ex.getMessage());
                break;
            case ErrorCode.PRIVILEGE_ERROR:
                apiError = new ApiError(HttpStatus.BAD_REQUEST);
                apiError.setMessage(ex.getMessage());
            default:
                apiError = new ApiError(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), ex);
                break;
        }
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

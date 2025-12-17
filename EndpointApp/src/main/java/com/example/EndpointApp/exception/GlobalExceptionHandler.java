package com.example.EndpointApp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFound(ProductNotFoundException productNotFoundException,
            HttpServletRequest httpServletRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Not Found",
                productNotFoundException.getMessage(),
                httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException,
            HttpServletRequest httpServletRequest) {

                String message= methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map(fieldError -> fieldError.getField() + ": "+ fieldError.getDefaultMessage()).collect(java.util.stream.Collectors.joining(", "));
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "Bad Request",
                message,
                httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> contraintViolation(ConstraintViolationException constraintViolationException,HttpServletRequest httpServletRequest){

        ConstraintViolation<?> violation =constraintViolationException.getConstraintViolations().stream().findFirst().orElse(null);
        String message;
        if(violation ==null){
            message="Validation Failed";
        }
        else{
            String path = violation.getPropertyPath().toString();
            String parts[] = path.split("\\.");
            String fieldName = parts[parts.length -1];
            message =fieldName + ": "+violation.getMessage();
        }
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST,
            "Bad Request",
            message,
            httpServletRequest.getRequestURI());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}

package com.example.demo.exceptions;

import com.example.demo.exceptions.user.UserAlreadyExistsException;
import com.example.demo.exceptions.user.UserException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnknownException(Exception exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
        errorDetail.setProperty("description", "Unknown internal server error");

        return errorDetail;

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ProblemDetail handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
        errorDetail.setProperty("description", "User already exists");

        return errorDetail;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ProblemDetail handleUsernameNotFoundException(UsernameNotFoundException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exception.getMessage());
        errorDetail.setProperty("description", "User not found");

        return errorDetail;
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handleBadCredentialsException(BadCredentialsException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exception.getMessage());
        errorDetail.setProperty("description", "Bad credentials");

        return errorDetail;
    }

    @ExceptionHandler(AuthorizationServiceException.class)
    public ProblemDetail handleAuthorizationServiceException(AuthorizationServiceException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exception.getMessage());
        errorDetail.setProperty("description", "Unauthorized access");

        return errorDetail;
    }

    @ExceptionHandler(ValidationException.class)
    public ProblemDetail handleValidationException(ValidationException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
        errorDetail.setProperty("description", "Validation failed");

        return errorDetail;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
        errorDetail.setProperty("description", "Validation failed");

        return errorDetail;
    }

    @ExceptionHandler(UserException.class)
    public ProblemDetail handleUserException(UserException exception) {
        ProblemDetail errorDetail;

        errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
        errorDetail.setProperty("description", "Wrong user data");

        return errorDetail;
    }




}

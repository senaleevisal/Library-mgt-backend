package dev.senaleevisal.library.advice;

import dev.senaleevisal.library.dto.ResponseBody.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice(basePackageClasses = dev.senaleevisal.library.controller.LibraryController.class)
public class LibraryAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseBody handleExceptions(SQLIntegrityConstraintViolationException e) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.addResponse("error", "This Mail has used earlier. Please use another mail.");
        responseBody.addResponse("status", "error");
        return responseBody;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBody handleValidationExceptions(MethodArgumentNotValidException ex) {
        ResponseBody response = new ResponseBody();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            response.addResponse("status", "error");
            response.addResponse("message", errorMessage);
        });
        return response;
    }
}
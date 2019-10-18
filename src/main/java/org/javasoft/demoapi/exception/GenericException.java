package org.javasoft.demoapi.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GenericException {

    @ExceptionHandler(DemoAPIException.class)
    public ResponseEntity<ErrorDTO> globalErrorHandler(DemoAPIException exception){
        return new ResponseEntity<>(exception.getErrorDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorDTO> httpErrorHandler(HttpClientErrorException htce){
        final val errorDTO = new ErrorDTO();
        errorDTO.setErrorMessage(htce.getMessage());
        errorDTO.setErrorType("Invalid Http Client");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ErrorDTO> resourceAccessException(ResourceAccessException rae){
        final val errorDTO = new ErrorDTO();
        errorDTO.setErrorMessage(rae.getMessage());
        errorDTO.setErrorType(" Service TimeOut");
        return new ResponseEntity<>(errorDTO, HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> methodArgumentNotValid(MethodArgumentNotValidException exception){
        final val errorDTO = new ErrorDTO();
        errorDTO.setErrorType(" Application Error ");
        //val builder = new StringBuilder("One or More Fields requires values ");
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            //builder.append(" Field Name [ " + fieldError.getField() + " ] Error [ " + fieldError.getDefaultMessage()+" ] : ");
            log.error("Field Name :::: [{}] Error :::: [{}] " ,fieldError.getField() , fieldError.getDefaultMessage());
        });
        errorDTO.setErrorMessage("One or More Fields is empty or has an incorrect value");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleConstraintViolation(ConstraintViolationException ex){
        final val errorDTO = new ErrorDTO();
        errorDTO.setErrorType(" Application Error ");
        errorDTO.setErrorMessage(" A database constraint has been violated ");
        log.error("Exception :::: {}",ex);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> handleDataIntegrityViolation(DataIntegrityViolationException ex){
        final val errorDTO = new ErrorDTO();
        errorDTO.setErrorType(" Application Error ");
        errorDTO.setErrorMessage(" A database constraint has been violated ");
        log.error("Exception :::: {}",ex);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity badRequestHandler(HttpServletRequest req, JsonMappingException ex) {
        log.error("Json Mapping Exception  :::: {}",ex);
        final val errorDTO = new ErrorDTO();
        errorDTO.setErrorType("JsonMapping Exception");
        errorDTO.setErrorMessage("Invalid Json Payload ");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}

package org.javasoft.demoapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DemoAPIException extends RuntimeException{

    private ErrorDTO errorDTO;

    public DemoAPIException(String errorType , String errorName){
        errorDTO = new ErrorDTO();
        errorDTO.setErrorType(errorType);
        errorDTO.setErrorMessage(errorName);
    }
}

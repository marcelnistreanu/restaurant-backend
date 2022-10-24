package com.ibm.restaurant.exception;

import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionDto> handleBusinessException(BusinessException exception) {
        ExceptionDto dto = new ExceptionDto();
        dto.message = exception.getMessage();
        dto.code = exception.getCode();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex){
        ExceptionDto dto = new ExceptionDto();
        dto.message = ex.getMessage();
        dto.code = "NOT_FOUND";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

}

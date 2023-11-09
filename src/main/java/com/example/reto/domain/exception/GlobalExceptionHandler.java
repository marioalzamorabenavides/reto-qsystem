package com.example.reto.domain.exception;

import com.example.reto.domain.mapper.ResponseMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<HashMap<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return ResponseMapper.buildCustomResponse(400, ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseMapper.buildCustomResponse(400, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, Object>> handleHttpMessageNotReadable(MethodArgumentNotValidException ex) {
        return ResponseMapper.buildCustomResponse(400, ex.getAllErrors().toString());
    }
}

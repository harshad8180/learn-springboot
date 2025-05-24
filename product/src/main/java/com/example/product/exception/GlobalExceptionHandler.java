package com.example.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.product.dto.ExceptionResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CategoryAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponseDTO> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException e,
			WebRequest webRequest) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(webRequest.getDescription(false),
				HttpStatus.CONFLICT, e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
	}

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFountException(CategoryNotFoundException e,
			WebRequest webRequest) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(webRequest.getDescription(false),
				HttpStatus.NOT_FOUND, e.getMessage(), LocalDateTime.now());
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
		}

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseDTO> handleGlobalException(Exception e, WebRequest webRequest) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), LocalDateTime.now());
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
		}

	}
}

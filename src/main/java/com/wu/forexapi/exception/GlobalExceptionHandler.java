package com.wu.forexapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wu.forexapi.model.ErrorStatus;
import com.wu.forexapi.model.ResponseObject;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DateRangeException.class)
	public ResponseEntity<ResponseObject> handleMyCustomException(DateRangeException ex) {
		ErrorStatus errorStatus = new ErrorStatus(null, "日期區間不符");
		ResponseObject response = new ResponseObject(errorStatus, null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(CurrencyEnumException.class)
	public ResponseEntity<ResponseObject> handleMyCustomException(CurrencyEnumException ex) {
		ErrorStatus errorStatus = new ErrorStatus(null, "查詢參數錯誤");
		ResponseObject response = new ResponseObject(errorStatus, null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

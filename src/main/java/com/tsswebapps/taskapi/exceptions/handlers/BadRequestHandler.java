package com.tsswebapps.taskapi.exceptions.handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.taskapi.exceptions.BadRequestException;
import com.tsswebapps.taskapi.exceptions.ResponseErrorDto;

@ControllerAdvice("com.tsswebapps.taskapi.controller")
public class BadRequestHandler {

	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ResponseErrorDto badRequestHandler(BadRequestException exception) {
		return new ResponseErrorDto(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), new Date());
	}
}

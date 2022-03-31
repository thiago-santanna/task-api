package com.tsswebapps.taskapi.exceptions.handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.taskapi.exceptions.NotFoundException;
import com.tsswebapps.taskapi.exceptions.ResponseErrorDto;

@ControllerAdvice("com.tsswebapps.taskapi.controller")
public class NotFoundHandler {

	@ResponseBody
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ResponseErrorDto notFoundHandler(NotFoundException exception) {
		return new ResponseErrorDto(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date());
	}
}

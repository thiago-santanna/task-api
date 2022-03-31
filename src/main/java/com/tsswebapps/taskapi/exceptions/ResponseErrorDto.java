package com.tsswebapps.taskapi.exceptions;

import java.util.Date;

public class ResponseErrorDto {
	private int httpCode;
	private String message;
	private Date dateError;

	public ResponseErrorDto(int httpCode, String message, Date dateError) {
		this.httpCode = httpCode;
		this.message = message;
		this.dateError = dateError;
	}

	public int getStatus() {
		return httpCode;
	}

	public void setStatus(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getMensagem() {
		return message;
	}

	public void setMensagem(String message) {
		this.message = message;
	}

	public Date getData() {
		return dateError;
	}

	public void setData(Date dateError) {
		this.dateError = dateError;
	}
}

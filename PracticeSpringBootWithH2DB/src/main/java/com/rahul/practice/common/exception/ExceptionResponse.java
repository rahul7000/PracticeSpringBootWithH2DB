package com.rahul.practice.common.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timeStamp;
	private String message;
	private String details;

	public ExceptionResponse() {

	}

	public ExceptionResponse(Date timeStamp, String message, String details) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getError() {
		return details;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
	}
}

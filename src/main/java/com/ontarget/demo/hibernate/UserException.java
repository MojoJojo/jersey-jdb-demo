package com.ontarget.demo.hibernate;

import javax.ws.rs.WebApplicationException;

public class UserException extends WebApplicationException{
	
	int code;
	int httpStatusCode;
	
	String link;
	String message;
	public int getCode() {
		return code;
	}
	public void setCode(int applicationErrorCode) {
		this.code = applicationErrorCode;
	}
	public int getStatus() {
		return httpStatusCode;
	}
	public void setStatus(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public UserException(int applicationErrorCode, int httpStatusCode, String link, String message) {
		super(message, httpStatusCode);
		this.code = applicationErrorCode;
		this.httpStatusCode = httpStatusCode;
		this.link= link;
		this.message = message;
		
	}
	

}

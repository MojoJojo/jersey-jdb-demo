package com.ontarget.demo.exception;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class SystemException implements ExceptionMapper<Throwable> {
	
	private final int INTERNAL_SERVER_ERROR = 500;

	@Override
	public Response toResponse(Throwable throwable) {

		ErrorMessage errorMessage = new ErrorMessage();
		setHttpStatus(throwable, errorMessage);
		errorMessage.setCode(INTERNAL_SERVER_ERROR);
		
		errorMessage.setMessage(throwable.getMessage());
		StringWriter errorStackTrace = new StringWriter();
		throwable.printStackTrace(new PrintWriter(errorStackTrace));
		errorMessage.setDeveloperMessage(errorStackTrace.toString());
		errorMessage.setLink("www.google.com");

		return Response.status(errorMessage.getStatus()).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
	}

	private void setHttpStatus(Throwable ex, ErrorMessage errorMessage) {
		if (ex instanceof WebApplicationException) {
			errorMessage.setStatus(((WebApplicationException) ex).getResponse().getStatus());
		} else {
			errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()); // defaults
																							// to
																							// internal
																							// server
																							// error
																							// 500
		}
	}

}

package com.ontarget.demo.exception;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.ontarget.demo.hibernate.UserException;

public class UserExceptionMapper implements ExceptionMapper<UserException> {
	
	private final String USER_EXCEPTION_MESSAGE="USER EXCEPTION: UNABLE TO PROCESS YOUR REQUEST. PLEASE VERIFY YOUR DATA AND TRY AGAIN";

	@Override
	public Response toResponse(UserException userException) {
		// TODO Auto-generated method stub
		return Response.status(new CustomStatusTypes(Status.BAD_REQUEST,USER_EXCEPTION_MESSAGE)).entity("Application Exception: " + userException.getMessage()).build();
	}

}

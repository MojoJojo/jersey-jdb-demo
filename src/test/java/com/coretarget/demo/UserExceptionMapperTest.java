package com.coretarget.demo;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.demo.exception.UserExceptionMapper;
import com.ontarget.demo.hibernate.UserException;

import org.junit.Assert;


public class UserExceptionMapperTest {
	
	private final String ERROR_URL="www.google.com";
	private final String TEST_MESSAGE="This is an error String";

	@Test
	public void userExceptionMapperTester() {
		
		UserExceptionMapper mapper = new UserExceptionMapper();
		
		UserException userException = new UserException(201, 401, ERROR_URL, TEST_MESSAGE);
		
		Response response = mapper.toResponse(userException);
		
		Assert.assertEquals(400,response.getStatus());
		
	}
	
}

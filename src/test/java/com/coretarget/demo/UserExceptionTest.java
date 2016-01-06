package com.coretarget.demo;

import org.junit.Test;

import com.ontarget.demo.hibernate.UserException;

import org.junit.Assert;

public class UserExceptionTest {
	private final String ERROR_URL="www.google.com";
	private final String TEST_MESSAGE="This is an error String";
	@Test
	public void createUserException() {
		UserException userException = new UserException(201, 401, ERROR_URL, TEST_MESSAGE);
		Assert.assertEquals(201,userException.getCode());
		Assert.assertEquals(401,userException.getStatus());
		Assert.assertEquals(ERROR_URL,userException.getLink());
		Assert.assertEquals(TEST_MESSAGE,userException.getMessage());
		
		userException.setCode(101);
		userException.setStatus(201);
		userException.setMessage("Hello World");
		userException.setLink("www.bing.com");
		
		Assert.assertEquals("Hello World",userException.getMessage());
		Assert.assertEquals("www.bing.com",userException.getLink());
		Assert.assertEquals(101,userException.getCode());
		Assert.assertEquals(201,userException.getStatus());
		
	}
	

}

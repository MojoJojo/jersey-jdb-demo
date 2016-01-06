package com.coretarget.demo;



import javax.ws.rs.NotFoundException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ontarget.demo.exception.ErrorMessage;
import com.ontarget.demo.hibernate.UserException;



public class ErrorMessageTest {
	private final String ERROR_URL="www.google.com";
	private final String TEST_MESSAGE="This is an error String";
	
	private static ErrorMessage errorMessage = new ErrorMessage();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void testGetStatus() {
		errorMessage.setCode(201);
		Assert.assertEquals(201, errorMessage.getCode());
	}

	@Test
	public void testSetStatus() {
		errorMessage.setStatus(500);
		Assert.assertEquals(500, errorMessage.getStatus());
	}

	@Test
	public void testGetCode() {
		errorMessage.setCode(201);
		Assert.assertEquals(201, errorMessage.getCode());
	}

	@Test
	public void testSetCode() {
		errorMessage.setCode(201);
		Assert.assertEquals(201, errorMessage.getCode());
	}

	@Test
	public void testGetMessage() {
		errorMessage.setMessage("Hello World");
		Assert.assertEquals("Hello World", errorMessage.getMessage());
	}

	@Test
	public void testSetMessage() {
		errorMessage.setMessage("Hello World");
		Assert.assertEquals("Hello World", errorMessage.getMessage());
	}

	@Test
	public void testGetDeveloperMessage() {
		errorMessage.setDeveloperMessage("Hello");
		Assert.assertEquals("Hello", errorMessage.getDeveloperMessage());
	}

	@Test
	public void testSetDeveloperMessage() {
		errorMessage.setDeveloperMessage("Hello");
		Assert.assertEquals("Hello", errorMessage.getDeveloperMessage());
	}

	@Test
	public void testGetLink() {
		errorMessage.setLink("www.yahoo.com");
		Assert.assertEquals("www.yahoo.com", errorMessage.getLink());
	}

	@Test
	public void testSetLink() {
		errorMessage.setLink("www.oo.com");
		Assert.assertEquals("www.oo.com", errorMessage.getLink());
	}

	@Test
	public void testErrorMessageUserException() {
		UserException userException = new UserException(201, 401, ERROR_URL, TEST_MESSAGE);
		ErrorMessage msg = new ErrorMessage(userException);
		
		
		Assert.assertEquals(userException.getLink(), msg.getLink());
		Assert.assertEquals(userException.getMessage(), msg.getMessage());
		Assert.assertEquals(userException.getCode(), msg.getCode());
		Assert.assertEquals(userException.getStatus(), msg.getStatus());
	}

	@Test
	public void testErrorMessageNotFoundException() {
		
		NotFoundException nfe = new NotFoundException("Something not found");
		ErrorMessage msg = new ErrorMessage(nfe);
		
		
		Assert.assertEquals(404, msg.getStatus());
		Assert.assertEquals(nfe.getMessage(), msg.getMessage());
		Assert.assertEquals("https://jersey.java.net/apidocs/2.8/jersey/javax/ws/rs/NotFoundException.html", msg.getLink());
		
	}

	@Test
	public void testErrorMessage() {
		
	}

}

package com.coretarget.demo;

import static org.junit.Assert.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import com.ontarget.demo.exception.SystemException;

public class SystemExceptionTest {

	@Test
	public void testToResponse() {
		SystemException exception1 = new SystemException();
		SystemException exception2= new SystemException();
		
		Exception testException = new Exception();
		WebApplicationException webException = new WebApplicationException(502);
		
		Response response1= exception1.toResponse(testException);
		Response response2 = exception2.toResponse(webException);
		
		Assert.assertEquals(500, response1.getStatus());
		Assert.assertEquals(502, response2.getStatus());
		
		
		
		
	}

}

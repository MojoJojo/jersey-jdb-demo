package com.coretarget.demo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ontarget.demo.exception.CustomStatusTypes;



public class CustomStatusTypesTest {

	private final CustomStatusTypes customStatusTypes = new CustomStatusTypes(Family.INFORMATIONAL, Status.FORBIDDEN.ordinal(), "Unknown Reason");
	

	@Test
	public void testGetFamily() {
		// TODO Auto-generated method stub
		Assert.assertEquals(0,Family.INFORMATIONAL.compareTo(customStatusTypes.getFamily()));

	}

	@Test
	public void testGetReasonPhrase() {
		// TODO Auto-generated method stub
		Assert.assertEquals("Unknown Reason", customStatusTypes.getReasonPhrase());
	}

	@Test
	public void testGetStatusCode() {
		// TODO Auto-generated method stub
		Assert.assertEquals(Status.FORBIDDEN.ordinal(), customStatusTypes.getStatusCode());
	}

}

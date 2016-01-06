package com.ontarget.demo.exception;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public class CustomStatusTypes implements StatusType {

	public CustomStatusTypes(final Family family, final int statusCode, final String reasonPhrase) {
		super();

		this.family = family;
		this.statusCode = statusCode;
		this.reasonPhrase = reasonPhrase;
	}

	public CustomStatusTypes(final Status status, final String reasonPhrase) {
		this(status.getFamily(), status.getStatusCode(), reasonPhrase);
	}

	@Override
	public Family getFamily() {
		// TODO Auto-generated method stub
		return family;

	}

	@Override
	public String getReasonPhrase() {
		// TODO Auto-generated method stub
		return reasonPhrase;
	}

	@Override
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return statusCode;
	}

	private final Family family;
	private final int statusCode;
	private final String reasonPhrase;

}

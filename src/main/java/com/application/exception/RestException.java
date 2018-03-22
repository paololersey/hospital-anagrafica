package com.application.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class RestException extends WebApplicationException {


	private static final long serialVersionUID = 6617679241790872844L;

	public RestException(String jsonObject) {
		super(Response.status(Response.Status.OK).entity(jsonObject).type(MediaType.APPLICATION_JSON).build());
	}
}

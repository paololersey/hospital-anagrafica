package com.application.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/RESTfulExample/rest/message/custom%20message
@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Custom message : " + msg;

		return Response.status(200).entity(result).build();

	}

}
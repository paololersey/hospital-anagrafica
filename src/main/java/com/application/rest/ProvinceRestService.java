package com.application.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

//http://localhost:8080/bankingAcademy/rest/province/getProvinceList
//http://localhost:8080/bankingAcademy/rest/province/getProvinceById/PD
@Path("/province")
public class ProvinceRestService {

	@Inject
	private transient Logger log;
	/** GET PROVINCE LIST */

	@GET
	@Path("/getProvinceList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProvinceList() {

		ArrayList<String> provinceList = new ArrayList<String>();

		// to be replaced by provinceBusinessLayer
		provinceList.add("BL");
		provinceList.add("PD");
		provinceList.add("RO");
		provinceList.add("TR");
		provinceList.add("VE");
		provinceList.add("VR");
		provinceList.add("VI");

		return Response.ok(provinceList).status(200).build();

	}

	/** GET PROVINCE BY ID */

	@GET
	@Path("/getProvinceById/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProvinceById(@PathParam("code") String code) {

		ArrayList<String> provinceList = new ArrayList<String>();

		// to be replaced by provinceBusinessLayer
		provinceList.add("PD");

		return Response.ok(provinceList.get(0)).status(200).build();

	}

}
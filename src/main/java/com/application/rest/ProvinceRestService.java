package com.application.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.application.business.ProvinciaBusiness;
import com.application.business.BO.ProvinciaBO;
import com.application.client.TO.ProvinciaTO;
import com.application.converter.ProvinciaConverter;
import com.application.exception.RestException;
import com.application.util.JsonUtil;

//http://localhost:8080/bank-academy/rest/province/getProvinceList
//http://localhost:8080/bank-academy/rest/province/getProvinceById/PD
@Path("/province")
public class ProvinceRestService {

	private static String PROV_NOT_GET = "PROV_001";
	private static String PROV_NOT_GET_DESC = "Errore nel recupero delle province";
	
	@Inject
	private transient Logger log;

	@Inject
	private ProvinciaBusiness provinciaBusiness;

	@Inject
	private ProvinciaConverter provinciaConverter;

	/** GET PROVINCE LIST */

	@GET
	@Path("/getProvinceList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProvinceList() {

		ArrayList<ProvinciaTO> provinceList = new ArrayList<ProvinciaTO>();

		// to be replaced by provinceBusinessLayer */
		/* no interaction with database */
		/*
		 * ArrayList<String> provinceList = new ArrayList<String>();
		 * 
		 * provinceList.add("BL"); provinceList.add("PD"); provinceList.add("RO");
		 * provinceList.add("TR"); provinceList.add("VE"); provinceList.add("VR");
		 * provinceList.add("VI");
		 */

		/*  */

		List<ProvinciaBO> returnedProvinciaBOList;
		try {
			returnedProvinciaBOList = provinciaBusiness.getProvince();
			for (ProvinciaBO provinciaBO : returnedProvinciaBOList) {
				provinceList.add(provinciaConverter.convertBOtoTO(provinciaBO));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(PROV_NOT_GET, PROV_NOT_GET_DESC).toString());
		}

		return Response.ok(provinceList).status(200).build();

	}

	/** GET PROVINCE BY ID */

	/*
	 * @GET
	 * 
	 * @Path("/getProvinceById/{code}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getProvinceById(@PathParam("code") String code) {
	 * 
	 * ArrayList<String> provinceList = new ArrayList<String>();
	 * 
	 * // to be replaced by provinceBusinessLayer provinceList.add("PD");
	 * 
	 * return Response.ok(provinceList.get(0)).status(200).build();
	 * 
	 * }
	 */

}
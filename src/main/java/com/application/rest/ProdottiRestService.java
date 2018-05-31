package com.application.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.application.business.ProdottoBusiness;
import com.application.business.BO.ProdottoBO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.client.TO.ProdottoTO;
import com.application.converter.ProdottoConverter;
import com.application.exception.RestException;
import com.application.util.JsonUtil;

//http://localhost:8080/RESTfulExample/rest/application/insertEditCustomer
@Path("/prodotti")
public class ProdottiRestService {

	private static String STANDARD_DESC = "Conto corrente standard";
	private static String GIOVANI_DESC = "Conto corrente under-30";
	private static String ROSA_DESC = "Conto corrente donne";
	private static String MONTAGNA_DESC = "Conto riservato residenti Belluno";
	private static String STANDARD_CODE = "STANDARD";
	private static String GIOVANI_CODE = "GIOVANI";
	private static String ROSA_CODE = "ROSA";
	private static String MOUNTAGNA_CODE = "MONTAGNA";

	private static String PROD_NOT_GET = "PROD_001";
	private static String PROD_NOT_GET_DESC = "Errore nel recupero dei prodotti";
	private static String PROD_NO_SUGG = "PROD_002";
	private static String PROD_NO_SUGG_DESC = "Eccezione generica nel suggerimento del prodotto";
	private static String PROD_NO_DETAILS = "PROD_003";
	private static String PROD_NO_DETAILS_DESC = "Eccezione generica nel dettaglio del prodotto";

	@Inject
	private transient Logger log;

	@Inject
	private ProdottoBusiness prodottoBusiness;

	@Inject
	private ProdottoConverter prodottoConverter;

	/** GET PRODOTTI LIST */
	@GET
	@Path("/getProdottiList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdottiList() {
		ArrayList<ProdottoTO> prodottiList = new ArrayList<ProdottoTO>();

		// to be replaced by prodottiBusinessLayer
		/* no interaction with database */

		/*
		 * ProdottoTO prodottoTO = new ProdottoTO();
		 * prodottoTO.setDescrizioneProdotto(STANDARD_DESC);
		 * prodottoTO.setNomeProdotto(STANDARD_CODE); prodottiList.add(prodottoTO);
		 * prodottoTO.setDescrizioneProdotto(GIOVANI_DESC);
		 * prodottoTO.setNomeProdotto(GIOVANI_CODE); prodottiList.add(prodottoTO);
		 * prodottoTO.setDescrizioneProdotto(ROSA_DESC);
		 * prodottoTO.setNomeProdotto(ROSA_CODE); prodottiList.add(prodottoTO);
		 * prodottoTO.setDescrizioneProdotto(MONTAGNA_DESC);
		 * prodottoTO.setNomeProdotto(MONTAGNA_CODE); prodottiList.add(prodottoTO);
		 */

		/*  */

		List<ProdottoBO> returnedProdottoBOList;
		try {
			returnedProdottoBOList = prodottoBusiness.getProdotti();
			for (ProdottoBO prodottoBO : returnedProdottoBOList) {
				prodottiList.add(prodottoConverter.convertBOtoTO(prodottoBO));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(PROD_NOT_GET, PROD_NOT_GET_DESC).toString());
		}

		return Response.ok(prodottiList).status(200).build();

	}

	/** GET PRODOTTO SUGGESTION */
	@POST
	@Path("/getProdottoSuggestion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdottoSuggestion(ClienteWithProdottoTO clienteWithProdottoTO) {

		// to be replaced by prodottiBusinessLayer
		/* no interaction with database */
		/*
		 * ProdottoTO prodottoTO = new ProdottoTO(); prodottoTO.setDescrizione(ROSA);
		 */

		/* */

		ProdottoTO prodottoTO = null;
		try {
			ProdottoBO prodottoBOReturned = prodottoBusiness.getProdottoSuggestion(clienteWithProdottoTO);
			prodottoTO = prodottoConverter.convertBOtoTO(prodottoBOReturned);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(PROD_NO_SUGG, PROD_NO_SUGG_DESC).toString());
		}

		return Response.ok(prodottoTO).status(200).build();

	}

	/** GET PRODOTTO DETAIL */

	@GET
	@Path("/getProdottoDetail/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdottoDetail(@PathParam("id") Long id) {
		ProdottoTO prodottoTO = null;

		// to be replaced by prodottiBusinessLayer
		/* no interaction with database */
		/*
		 * prodottoTO.setDescrizioneProdotto(MONTAGNA);
		 * prodottoTO.setNomeProdotto(STANDARD); prodottoTO.setId(2);
		 */

		/* */
		try {
			ProdottoBO prodottoBOReturned = prodottoBusiness.getProdottoById(id);
			prodottoTO = prodottoConverter.convertBOtoTO(prodottoBOReturned);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(PROD_NO_DETAILS, PROD_NO_DETAILS_DESC).toString());
		}
		return Response.ok(prodottoTO).status(200).build();

	}

}
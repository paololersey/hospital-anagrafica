package com.application.rest;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.application.client.TO.ClienteWithProdottoTO;
import com.application.client.TO.ProdottoTO;
import com.application.dal.dao.ProdottoDao;
import com.application.mapper.Mapper;

//http://localhost:8080/RESTfulExample/rest/application/insertEditCustomer
@Path("/prodotti")
@RequestScoped
public class ProdottiRestService {

	private static String PRODOTTO_PIU_PREVIDENZA = "Prodotto piu' previdenza";
	private static String PRODOTTO_PREVIDENZA_GIOVANE = "Prodotto previdenza giovani";
	private static String PRODOTTO_INVESTIMENTO_DONNA_YOUNG = "Prodotto investimento donna young";
	private static String PRODOTTO_INVESTIMENTO_SENIOR_OVER_70 = "Prodotto investimento senior over 70";

	@Inject
	private ProdottoDao prodottoDao;


	@Inject
	private Logger log;

	/** GET PRODOTTI LIST */
	@GET
	@Path("/getProdottiList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdottiList() {
		ArrayList<ProdottoTO> prodottiList = new ArrayList<ProdottoTO>();

		// to be replaced by prodottiBusinessLayer
		try {
			ProdottoTO prodottoTO = new ProdottoTO();
			prodottoTO.setDescrizione(PRODOTTO_PIU_PREVIDENZA);
			prodottiList.add(prodottoTO);
			prodottoTO.setDescrizione(PRODOTTO_PREVIDENZA_GIOVANE);
			prodottiList.add(prodottoTO);
			prodottoTO.setDescrizione(PRODOTTO_INVESTIMENTO_DONNA_YOUNG);
			prodottiList.add(prodottoTO);
			prodottoTO.setDescrizione(PRODOTTO_INVESTIMENTO_SENIOR_OVER_70);
			prodottiList.add(prodottoTO);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}

		return Response.ok(prodottiList).status(200).build();

	}

	/** GET PRODOTTO SUGGESTION */
	@GET
	@Path("/getProdottoSuggestion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdottoSuggestion(ClienteWithProdottoTO clienteWithProdottoTO) {
		ProdottoTO prodottoTO = new ProdottoTO();

		// to be replaced by prodottiBusinessLayer
		prodottoTO.setDescrizione(PRODOTTO_INVESTIMENTO_DONNA_YOUNG);

		return Response.ok(prodottoTO).status(200).build();

	}

	/** GET PRODOTTO DETAIL */
	
	@GET
	@Path("/getProdottoDetail/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdottoSuggestion(@PathParam("id") Long id) {
		ProdottoTO prodottoTO = new ProdottoTO();

		// to be replaced by prodottiBusinessLayer
		prodottoTO.setDescrizione(PRODOTTO_PREVIDENZA_GIOVANE);
		prodottoTO.setCodice("03D2");

		return Response.ok(prodottoTO).status(200).build();

	}

}
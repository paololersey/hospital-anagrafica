package com.application.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.application.client.TO.ClienteWithProdottoSearchTO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.client.TO.ContoCorrenteSearchTO;
import com.application.client.TO.ContoCorrenteTO;

//http://localhost:8080/RESTfulExample/rest/message/custom%20message
@Path("/contoCorrente")
public class ContoCorrenteRestService {
	
	private static String PRODOTTO_PIU_PREVIDENZA = "Prodotto piu' previdenza";
	
	/** GET ANAGRAFICA TABLE WITH PRODOTTO INDICATION FOR THE MAIN GRID */

	@POST
	@Path("/getConto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContoById(ContoCorrenteSearchTO contoCorrenteSearchTO) {

		// replaced by contocorrenteBusinessLayer through
		// contoCorrenteSearchTO
		// and get conto corrente
		ArrayList<ContoCorrenteTO> contoCorrenteList = new ArrayList<>();

		ContoCorrenteTO contoCorrenteTO = new ContoCorrenteTO();
		contoCorrenteTO.setDescProdotto(PRODOTTO_PIU_PREVIDENZA);
		contoCorrenteTO.setNomeCognomeCliente("COGNOME NOME CUSTOM");
		contoCorrenteTO.setNumContoCorrente("000013004345");
		
		contoCorrenteList.add(contoCorrenteTO);
		
		return Response.ok(contoCorrenteList).status(200).build();

	}

}
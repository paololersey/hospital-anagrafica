package com.application.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.application.client.TO.ClienteWithProdottoSearchTO;
import com.application.client.TO.ClienteWithProdottoTO;

//http://localhost:8080/RESTfulExample/rest/message/custom%20message
@Path("/clienti")
public class ClientiRestService {
	
	private static String PRODOTTO_PIU_PREVIDENZA = "Prodotto piu' previdenza";
	
	/** GET ANAGRAFICA TABLE WITH PRODOTTO INDICATION FOR THE MAIN GRID */

	@POST
	@Path("/getClientiWithProdotto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnagraficaWithProdotto(ClienteWithProdottoSearchTO clienteWithProdottoSearchTO) {

		// replaced by clienteWithProdottoBusinessLayer through
		// clienteWithProdottoSearchTO
		// and get clientiWithProdottoList
		ArrayList<ClienteWithProdottoTO> clientiWithProdottoList = new ArrayList<ClienteWithProdottoTO>();

		ClienteWithProdottoTO clienteWithProdottoTO = new ClienteWithProdottoTO();
		clienteWithProdottoTO.setCognome("SURNAME");
		clienteWithProdottoTO.setNome("NAME");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(Calendar.YEAR,-40);
		clienteWithProdottoTO.setDataNascita(gc.getTime());
		clienteWithProdottoTO.setCodiceFiscale("CODICE_FISCALE_1");
		clienteWithProdottoTO.setNome("NAME");
		clienteWithProdottoTO.setSesso("M");
		clienteWithProdottoTO.setProvincia("PD");
		clienteWithProdottoTO.setDescProdotto(PRODOTTO_PIU_PREVIDENZA);
		
		clientiWithProdottoList.add(clienteWithProdottoTO);
		
		return Response.ok(clientiWithProdottoList).status(200).build();

	}

	/** INSERT OR EDIT A CLIENT WITH TABLES RELATED */

	@PUT
	@Path("/insertEditCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertEditCliente(ClienteWithProdottoTO clienteWithProdottoTO) {

		// invoke clienteProdottoBusinessLayer to save/eidt cliente
		
		return Response.ok(clienteWithProdottoTO).status(200).build();


	}

	/** DELETE A CLIENT WITH TABLES RELATED */

	@DELETE
	@Path("/deleteCliente/{id}")
	public Response deleteCliente(@PathParam("id") Long id) {

		// invoke clienteProdottoBusinessLayer to delete cliente
		
		return Response.ok(id).status(200).build();
	

	}

}
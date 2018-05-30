package com.application.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.application.business.ClienteProdottoBusiness;
import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.converter.ClienteConverter;
import com.application.exception.BusinessException;
import com.application.exception.ConverterException;
import com.application.exception.RestException;
import com.application.util.JsonUtil;

@Path("/clienti")
public class ClientiRestService {

	@Inject
	private ClienteProdottoBusiness clienteProdottoBusiness;

	@Inject
	private ClienteConverter clienteConverter;

	@Inject
	private transient Logger log;

	private static String CLIENTI_GET_FAIL = "CLIENT_001";
	private static String CLIENTI_GET_FAIL_DESC = "Errore nel recupero del cliente";
	private static String INSERT_EDIT_CLIENT_FAIL = "CLIENT_002";
	private static String INSERT_EDIT_CLIENT_FAIL_DESC = "Errore nell'inserimento/update del cliente";
	private static String DELETE_CLIENTE_FAIL = "CLIENT_003";
	private static String DELETE_CLIENTE_FAIL_DESC = "Errore nel delete del cliente";

	/** GET ANAGRAFICA TABLE WITH PRODOTTO INDICATION FOR THE MAIN GRID */

	@POST
	@Path("/getClientiWithProdotto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientiWithProdotto(ClienteWithProdottoSearch clienteWithProdottoSearch) {

		// replaced by clienteWithProdottoBusinessLayer through
		// clienteWithProdottoSearchTO
		// and get clientiWithProdottoList
		ArrayList<ClienteWithProdottoTO> clientiWithProdottoList = new ArrayList<ClienteWithProdottoTO>();

		/*
		 * ClienteWithProdottoTO clienteWithProdottoTO = new ClienteWithProdottoTO();
		 * clienteWithProdottoTO.setCognome("SURNAME");
		 * clienteWithProdottoTO.setNome("NAME"); GregorianCalendar gc = new
		 * GregorianCalendar(); gc.setTime(new Date()); gc.add(Calendar.YEAR, -40);
		 * clienteWithProdottoTO.setDataNascita(gc.getTime());
		 * clienteWithProdottoTO.setCodiceFiscale("CODICE_FISCALE_1");
		 * clienteWithProdottoTO.setNome("NAME"); clienteWithProdottoTO.setSesso("M");
		 */
		/*
		 * clienteWithProdottoTO.setProvincia("PD");
		 * clienteWithProdottoTO.setDescProdotto(PRODOTTO_PIU_PREVIDENZA);
		 * 
		 * clientiWithProdottoList.add(clienteWithProdottoTO);
		 */
		try {
			List<ClienteBO> returnedClienteBOList = clienteProdottoBusiness
					.getClientiWithProdotto(clienteWithProdottoSearch);

			for (ClienteBO clientBO : returnedClienteBOList) {
				clientiWithProdottoList.add(clienteConverter.convertBOtoTO(clientBO));
			}
		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(CLIENTI_GET_FAIL, CLIENTI_GET_FAIL_DESC).toString());
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(CLIENTI_GET_FAIL, CLIENTI_GET_FAIL_DESC).toString());
		}

		return Response.ok(clientiWithProdottoList).status(200).build();

	}

	/** INSERT OR EDIT A CLIENT WITH TABLES RELATED */

	@PUT
	@Path("/insertEditCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertEditCliente(ClienteWithProdottoTO clienteWithProdottoTO) {
		ClienteWithProdottoTO clienteWithProdottoTOReturned = null;

		try {
			ClienteBO clienteBO = clienteConverter.convertTOtoBO(clienteWithProdottoTO);

			ClienteBO returnedClienteBO = clienteProdottoBusiness.saveCliente(clienteBO);

			clienteWithProdottoTOReturned = clienteConverter.convertBOtoTO(returnedClienteBO);

		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(INSERT_EDIT_CLIENT_FAIL, INSERT_EDIT_CLIENT_FAIL_DESC).toString());
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			throw new RestException(
					JsonUtil.writeJsonError(INSERT_EDIT_CLIENT_FAIL, INSERT_EDIT_CLIENT_FAIL_DESC).toString());
		}

		return Response.ok(clienteWithProdottoTOReturned).status(200).build();

	}

	/** DELETE A CLIENT WITH TABLES RELATED */

	@DELETE
	@Path("/deleteCliente/{id}")
	public Response deleteCliente(@PathParam("id") Long id) {
		Long idReturned = null;
		// invoke clienteProdottoBusinessLayer to delete cliente
		try {
			idReturned = clienteProdottoBusiness.deleteCliente(id);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			throw new RestException(JsonUtil.writeJsonError(DELETE_CLIENTE_FAIL, DELETE_CLIENTE_FAIL_DESC).toString());
		}

		return Response.ok(idReturned).status(200).build();

	}

}
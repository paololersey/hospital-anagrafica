package com.application.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import com.application.business.BO.ClienteBO;
import com.application.dal.dao.ClienteDao;

@Stateless
@Transactional
/*@TransactionManagement(TransactionManagementType.CONTAINER)  this is default */
/*@TransactionAttribute(TransactionAttributeType.REQUIRED) /* this is default */
public class ClienteProdottoBusinessImpl implements ClienteProdottoBusiness {

	/*
	 * su questo layer possoe effettuare operazioni logiche e qui dovrebbe stare la
	 * transazione
	 */
	
	@Inject
	private transient Logger log;
	

	@Inject
	private ClienteDao clienteDao;

	@Override
	public ClienteBO saveCliente(ClienteBO clienteBO) throws Exception {
		ClienteBO returnedClienteBO = null;

		try {

			returnedClienteBO = clienteDao.save(clienteBO);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException();
		}
		return returnedClienteBO;

	}

}

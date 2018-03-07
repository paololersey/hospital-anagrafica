package com.application.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import com.application.business.BO.ClienteBO;
import com.application.business.BO.ContoBO;
import com.application.business.BO.ProdottoBO;
import com.application.business.BO.ProvinciaBO;
import com.application.client.TO.ClienteWithProdottoSearch;
import com.application.dal.dao.ClienteDao;
import com.application.dal.dao.ProdottoDao;
import com.application.dal.dao.ProvinciaDao;

@Stateless
@Transactional
/*
 * @TransactionManagement(TransactionManagementType.CONTAINER) this is default
 */
/*
 * @TransactionAttribute(TransactionAttributeType.REQUIRED) /* this is default
 */
public class ClienteProdottoBusinessImpl implements ClienteProdottoBusiness {

	/*
	 * su questo layer possoe effettuare operazioni logiche e qui dovrebbe stare la
	 * transazione
	 */

	private static String CONTO_PREFIX = "00000000";

	@Inject
	private transient Logger log;

	@Inject
	private ProvinciaDao provinciaDao;

	@Inject
	private ProdottoDao prodottoDao;

	@Inject
	private ClienteDao clienteDao;

	@Override
	public ClienteBO saveCliente(ClienteBO clienteBO) throws Exception {
		ClienteBO returnedClienteBO = null;

		try {

			ProvinciaBO provinciaBO = provinciaDao.getByCodice(clienteBO.getCodiceProvincia());
			clienteBO.setProvinciaBO(provinciaBO);
			
			
			
			if (clienteBO.getId() == null) {
				Set<ContoBO> contoBOList = new HashSet<>();
				ContoBO contoBO = new ContoBO();
				
				contoBO.setDataApertura(new Date());
				contoBO.setNumeroContoCorrente(CONTO_PREFIX + "2");
				contoBOList.add(contoBO);

				clienteBO.addContoBO(contoBO);

				returnedClienteBO = clienteDao.save(clienteBO);
				
			} else {
				if (clienteBO.getContoBOList() != null && clienteBO.getContoBOList().size() > 0) {
					for(ContoBO contoBO: clienteBO.getContoBOList()) {
						
					}
				}
				returnedClienteBO = clienteDao.merge(clienteBO);
			}

			// other update on eventDate to show transactionality

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException();
		}
		return returnedClienteBO;

	}

	@Override
	public List<ClienteBO> getClientiWithProdotto(ClienteWithProdottoSearch clienteWithProdottoSearch) {

		List<ClienteBO> clientiWithProdottList = new ArrayList<>();
		try {
			clientiWithProdottList = clienteDao.getClienti(clienteWithProdottoSearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException(e);
		}
		return clientiWithProdottList;
	}

}

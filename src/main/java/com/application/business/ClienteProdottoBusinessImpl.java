package com.application.business;

import java.util.Date;
import java.util.HashSet;
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

			ProdottoBO prodottoBO = prodottoDao.getByNomeProdotto(clienteBO.getNomeProdotto());
			ContoBO contoBO = new ContoBO();
			Set<ContoBO> contoBOList = new HashSet<>();
			contoBO.setProdottoBO(prodottoBO);
			contoBO.setDataApertura(new Date());
			contoBO.setNumeroContoCorrente(CONTO_PREFIX + "2");
			contoBOList.add(contoBO);
			clienteBO.setContoBOList(contoBOList);
			ProvinciaBO provinciaBO = provinciaDao.getByCodice(clienteBO.getCodiceProvincia());
			clienteBO.setProvinciaBO(provinciaBO);
			if (clienteBO.getId() == null) {
				returnedClienteBO = clienteDao.save(clienteBO);
			} else {
				returnedClienteBO = clienteDao.merge(clienteBO);
			}
			
			// other update on eventDate to show transactionality

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException();
		}
		return returnedClienteBO;

	}

}

package com.application.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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
import com.application.converter.ClienteConverter;
import com.application.dal.dao.ClienteDao;
import com.application.dal.dao.ContoDao;
import com.application.dal.dao.ProdottoDao;
import com.application.dal.dao.ProvinciaDao;
import com.application.exception.BusinessException;
import com.application.exception.DaoException;

@Stateless
@Transactional
/*
 * @TransactionManagement(TransactionManagementType.CONTAINER) this is default
 */
/*
 * @TransactionAttribute(TransactionAttributeType.REQUIRED) /* this is default
 */
public class ClienteProdottoBusinessImpl implements ClienteProdottoBusiness {

	private static String className = ClienteProdottoBusinessImpl.class.getName();
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

	@Inject
	private ContoDao contoDao;

	@Override
	public ClienteBO saveCliente(ClienteBO clienteBO) throws BusinessException {
		ClienteBO returnedClienteBO = null;

		try {

			ProvinciaBO provinciaBO = provinciaDao.getByCodice(clienteBO.getCodiceProvincia());
			clienteBO.setProvinciaBO(provinciaBO);
			ProdottoBO prodottoBO = prodottoDao.getByNomeProdotto(clienteBO.getNomeProdotto());

			if (clienteBO.getId() == null) {
				Random r=new Random();
				Set<ContoBO> contoBOList = new HashSet<>();
				ContoBO contoBO = new ContoBO();

				contoBO.setProdottoBO(prodottoBO);
				contoBO.setDataApertura(new Date());
				contoBO.setNumeroContoCorrente(CONTO_PREFIX +""+ r.nextInt());
				contoBOList.add(contoBO);

				clienteBO.addContoBO(contoBO);
				returnedClienteBO = clienteDao.save(clienteBO);

			} else {
				
				ContoBO contoBO = contoDao.getContoByIdCliente(clienteBO.getId());
				contoBO.setProdottoBO(prodottoBO);
				clienteBO.addContoBO(contoBO);
				
				returnedClienteBO = clienteDao.merge(clienteBO);
			}

			// other update on eventDate to show transactionality

		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new BusinessException("Error in class " + className + ", method saveCliente ", e);
		}
		
		return returnedClienteBO;

	}

	@Override
	public List<ClienteBO> getClientiWithProdotto(ClienteWithProdottoSearch clienteWithProdottoSearch) throws BusinessException {

		List<ClienteBO> clientiWithProdottList = new ArrayList<>();
		try {
			clientiWithProdottList = clienteDao.getClienti(clienteWithProdottoSearch);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new BusinessException("Error in class " + className + ", method getClientiWithProdotto ", e);
		}
		return clientiWithProdottList;
	}

	@Override
	public Long deleteCliente(Long id) throws BusinessException {
		try {
			ClienteBO clienteBOReturned = clienteDao.getClienteById(id);
			id = clienteDao.delete(clienteBOReturned);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new BusinessException("Error in class " + className + ", method deleteCliente ", e);
		}
		return id;
	}

}

package com.application.dal.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;
import com.application.converter.ClienteConverter;
import com.application.dal.entity.Cliente;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ClienteDaoImpl implements ClienteDao {

	private static String className = ClienteDaoImpl.class.getName();

	@Inject
	private transient Logger log;

	@Inject
	private ClienteConverter clienteConverter;

	@Override
	public ClienteBO merge(ClienteBO clienteBO) throws Exception {

		ClienteBO returned = null;
		try {

			Cliente cliente = clienteConverter.convertBOToEntity(clienteBO);

			getCurrentSession().merge(cliente);

			returned = clienteConverter.convertEntityToBO(cliente);

		} catch (MappingException me) {
			log.error(me);
			throw new HibernateException("hibernate mapping exception", me);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method merge, exception = " + e.getMessage());
		}

		return returned;

	}

	@Override
	public ClienteBO save(ClienteBO clienteBO) throws Exception {

		ClienteBO returned = null;
		try {

			Cliente cliente = clienteConverter.convertBOToEntity(clienteBO);

			getCurrentSession().save(cliente);

			returned = clienteConverter.convertEntityToBO(cliente);

		} catch (MappingException me) {
			log.error(me);
			throw new HibernateException("Hibernate mapping Exception in class " + className
					+ ", method save, exception = " + me.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method save, exception = " + e.getMessage());
		}

		return returned;

	}

	/*
	 * manual method to handle session: not to do if boundary transaction is on the
	 * business layer
	 */

	@Override
	public ClienteBO saveOpeningAndClosingSession(ClienteBO clienteBO) throws Exception {

		ClienteBO returned = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Cliente cliente = clienteConverter.convertBOToEntity(clienteBO);

		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();

		returned = clienteConverter.convertEntityToBO(cliente);

		return returned;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getAll() throws Exception {
		return (List<Cliente>) getCurrentSession().createCriteria(Cliente.class).list();
	}

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteBO> getClienti(ClienteWithProdottoSearch clienteWithProdottoSearch) throws Exception {

		try {
			Criteria criteria = getCurrentSession().createCriteria(Cliente.class);
			criteria.createAlias("contiList", "conto");
			criteria.createAlias("conto.prodotto", "prodotto");
			criteria.createAlias("provincia", "provincia");
			criteria.add(Restrictions.isNotNull("conto.dataApertura"));

			if (clienteWithProdottoSearch.getCodiceFiscale() != null) {
				criteria.add(Restrictions.eq("codiceFiscale", clienteWithProdottoSearch.getCodiceFiscale()));
			}

			if (clienteWithProdottoSearch.getCognome() != null) {
				criteria.add(Restrictions.eq("cognome", clienteWithProdottoSearch.getCognome()));
			}

			if (clienteWithProdottoSearch.getNome() != null) {
				criteria.add(Restrictions.eq("nome", clienteWithProdottoSearch.getNome()));
			}

			if (clienteWithProdottoSearch.getSesso() != null) {
				criteria.add(Restrictions.eq("sesso", clienteWithProdottoSearch.getSesso()));
			}

			if (clienteWithProdottoSearch.getDescProdotto() != null) {
				criteria.add(Restrictions.eq("prodotto.nomeProdotto", clienteWithProdottoSearch.getDescProdotto()));
			}

			if (clienteWithProdottoSearch.getNumContoCorrente() != null) {
				criteria.add(
						Restrictions.eq("conto.numeroContoCorrente", clienteWithProdottoSearch.getNumContoCorrente()));
			}

			if (clienteWithProdottoSearch.getCodiceProvincia() != null) {
				criteria.add(Restrictions.eq("provincia.codice", clienteWithProdottoSearch.getCodiceProvincia()));
			}
			
			Restrictions.ne("dataFine", null);

			List<Cliente> clientList = (List<Cliente>) criteria.list();
			List<ClienteBO> clienteBOList = new ArrayList<ClienteBO>();

			for (Cliente cliente : clientList) {
				clienteBOList.add(clienteConverter.convertEntityToBO(cliente));
			}

			return clienteBOList;

		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new HibernateException(
					"Error in class " + className + ", method getClienti, exception = " + e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method getClienti, exception = " + e.getMessage());
		}
	}

	@Override
	public ClienteBO getClienteById(Long id) throws Exception {
		ClienteBO clienteBO = null;

		try {
			Criteria criteria = getCurrentSession().createCriteria(Cliente.class);
			criteria.add(Restrictions.eq("id", id));
			criteria.createAlias("contiList", "conto");
			Cliente cliente = (Cliente) criteria.uniqueResult();
			clienteBO = clienteConverter.convertEntityToBO(cliente);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception(
					"Error in class " + className + ", method getClienteById, exception = " + e.getMessage());
		}

		return clienteBO;

	}

	@Override
	public Long delete(ClienteBO clienteBO) throws Exception {
		try {
			Cliente cliente = clienteConverter.convertBOToEntity(clienteBO);
			cliente.setDataFine(new Date());
			getCurrentSession().merge("cliente", cliente);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method delete, exception = " + e.getMessage());
		}

		return clienteBO.getId();
	}

}

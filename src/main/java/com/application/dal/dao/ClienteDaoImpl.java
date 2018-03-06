package com.application.dal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;

import com.application.business.BO.ClienteBO;
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
			throw new HibernateException("hibernate mapping exception", me);
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
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			Cliente cliente = clienteConverter.convertBOToEntity(clienteBO);

			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();

			returned = clienteConverter.convertEntityToBO(cliente);

		} catch (MappingException me) {
			log.error(me);
			throw new HibernateException("hibernate mapping exception", me);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Exception during insert cliente ", e);
		}

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


}

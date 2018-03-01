package com.application.dal.dao;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;

import com.application.business.BO.ClienteBO;
import com.application.converter.ClienteConverter;
import com.application.dal.entity.Cliente;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ClienteDaoImpl implements ClienteDao {

	@Inject
	private Logger log;
	
//	@Inject
//	private Session session;
	
	@Inject
	private ClienteConverter clienteConverter;

	@Override
	public ClienteBO save(ClienteBO clienteBO) throws Exception {

		ClienteBO returned = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

		     session.beginTransaction();
			
			Cliente cliente = clienteConverter.convertBOToEntity(clienteBO);

			session.save(cliente);

			returned = clienteConverter.convertEntityToBO(cliente);
			
			session.getTransaction().commit();

		} catch (MappingException me) {
			log.error(me);
			throw new HibernateException("hibernate mapping exception", me);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Exception during insert cliente", e);
		}

		return returned;

	}

	@Override
	public Cliente getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.application.dal.dao;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;

import com.application.dal.model.Customer;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ClienteDaoImpl implements ClienteDao {

	@Inject
	private Logger log;

	@Override
	public Customer save(Customer customer) throws Exception {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			session.save(customer);

			session.getTransaction().commit();

		} catch (MappingException me) {
			log.error(me);
			throw new HibernateException("hibernate mapping exception", me);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Customer exception", e);
		}

		return customer;

	}

	@Override
	public Customer getAll(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

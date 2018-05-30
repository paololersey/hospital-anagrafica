package com.application.dal.dao;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ContoBO;
import com.application.converter.ContoConverter;
import com.application.dal.entity.Conto;
import com.application.exception.ConverterException;
import com.application.exception.DaoException;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ContoDaoImpl implements ContoDao {

	private static String className = ContoDaoImpl.class.getName();

	@Inject
	private transient Logger log;

	@Inject
	private ContoConverter contoConverter;

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}

	@Override
	public ContoBO getContoByIdCliente(Long idCliente) throws DaoException {

		ContoBO contoBO = null;

		try {
			Conto conto = (Conto) getCurrentSession().createCriteria(Conto.class).createAlias("cliente", "cliente")
					.add(Restrictions.eq("cliente.id", idCliente)).uniqueResult();
			contoBO = contoConverter.convertEntityToBO(conto);
		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate mapping exception");
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate generic exception = " + e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DaoException("Error in class " + className + ", method getContoByIdCliente, exception = " + e.getMessage());
		}

		return contoBO;
	}

}

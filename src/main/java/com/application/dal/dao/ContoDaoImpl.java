package com.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ContoBO;
import com.application.business.BO.ContoBO;
import com.application.converter.ContoConverter;
import com.application.dal.entity.Conto;
import com.application.dal.entity.Conto;
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
	public ContoBO getContoByIdCliente(Long idCliente) throws Exception {

		ContoBO contoBO = null;

		try {
			Conto conto = (Conto) getCurrentSession().createCriteria(Conto.class).createAlias("cliente", "cliente")
					.add(Restrictions.eq("cliente.id", idCliente)).uniqueResult();
			contoBO = contoConverter.convertEntityToBO(conto);
		} catch (MappingException me) {
			log.error(me);
			throw new MappingException("Hibernate mapping Exception in class " + className
					+ ", method saveOpeningAndClosingSession, exception = " + me.getMessage());
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new HibernateException("Error in class " + className + ", method getContoByIdCliente, exception" + e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method getContoByIdCliente, exception" + e);
		}

		return contoBO;
	}

}

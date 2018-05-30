package com.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ProvinciaBO;
import com.application.converter.ProvinciaConverter;
import com.application.dal.entity.Provincia;
import com.application.exception.ConverterException;
import com.application.exception.DaoException;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ProvinciaDaoImpl implements ProvinciaDao {

	private static String className = ProvinciaDaoImpl.class.getName();

	@Inject
	private transient Logger log;

	@Inject
	private ProvinciaConverter provinciaConverter;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProvinciaBO> getAll() throws DaoException {

		ArrayList<ProvinciaBO> provinciaBOList;
		try {
			provinciaBOList = new ArrayList<ProvinciaBO>();
			List<Provincia> provinceList = getCurrentSession().createCriteria(Provincia.class).list();

			for (Provincia provincia : provinceList) {
				provinciaBOList.add(provinciaConverter.convertEntityToBO(provincia));
			}
		} catch (QueryException e) {
			log.error(e.getMessage(), e);
			throw new QueryException("Error in class " + className + ", method getAll, exception");
		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("error in converter");
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate generic exception");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DaoException("Error in class " + className + ", method getAll");
		}

		return provinciaBOList;
	}

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}

	@Override
	public ProvinciaBO getByCodice(String codice) throws DaoException {
		ProvinciaBO provinciaBO = null;

		try {
			Provincia provincia = (Provincia) getCurrentSession().createCriteria(Provincia.class)
					.add(Restrictions.eq("codice", codice)).uniqueResult();
			provinciaBO = provinciaConverter.convertEntityToBO(provincia);
		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("error in converter");
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate generic exception");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DaoException("Error in class " + className + ", method getAll");
		}


		return provinciaBO;
	}

}

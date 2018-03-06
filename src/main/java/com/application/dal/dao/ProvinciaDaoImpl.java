package com.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ProvinciaBO;
import com.application.converter.ProvinciaConverter;
import com.application.dal.entity.Provincia;
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
	public List<ProvinciaBO> getAll() throws Exception {

		ArrayList<ProvinciaBO> provinciaBOList;
		try {
			provinciaBOList = new ArrayList<ProvinciaBO>();
			List<Provincia> provinceList = getCurrentSession().createCriteria(Provincia.class).list();

			for (Provincia provincia : provinceList) {
				provinciaBOList.add(provinciaConverter.convertEntityToBO(provincia));
			}
		} catch (QueryException e) {
			log.error(e.getMessage(), e);
			throw new QueryException("Error in class " + className + ", method getAll, exception" + e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method getAll, exception" + e);
		}

		return provinciaBOList;
	}

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}

	@Override
	public ProvinciaBO getByCodice(String codice) throws Exception {
		ProvinciaBO provinciaBO = null;

		try {
			Provincia provincia = (Provincia) getCurrentSession().createCriteria(Provincia.class)
					.add(Restrictions.eq("codice", codice)).uniqueResult();
			provinciaBO = provinciaConverter.convertEntityToBO(provincia);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("Error in class " + className + ", method getByCodice, exception" + e);
		}

		return provinciaBO;
	}

}

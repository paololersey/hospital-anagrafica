package com.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.application.business.BO.ProdottoBO;
import com.application.business.BO.ProvinciaBO;
import com.application.converter.ProvinciaConverter;
import com.application.dal.entity.Prodotto;
import com.application.dal.entity.Provincia;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ProvinciaDaoImpl implements ProvinciaDao {

	@Inject
	private transient Logger log;

	@Inject
	private ProvinciaConverter provinciaConverter;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProvinciaBO> getAll() throws Exception {

		ArrayList<ProvinciaBO> provinciaBOList = new ArrayList<ProvinciaBO>();
		List<Provincia> provinceList = getCurrentSession().createCriteria(Provincia.class).list();
		
		for(Provincia provincia: provinceList) {
			provinciaBOList.add(provinciaConverter.convertEntityToBO(provincia));
		};

		return provinciaBOList;
	}
	

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}


}

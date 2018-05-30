package com.application.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import com.application.business.BO.ProvinciaBO;
import com.application.dal.dao.ClienteDaoImpl;
import com.application.dal.dao.ProvinciaDao;
import com.application.exception.BusinessException;
import com.application.exception.DaoException;

@Stateless
@Transactional
public class ProvinciaBusinessImpl implements ProvinciaBusiness {

	private static String className = ClienteDaoImpl.class.getName();
	
	/*
	 * su questo layer possoe effettuare operazioni logiche e qui deve stare la
	 * transazione
	 */

	@Inject
	private transient Logger log;

	@Inject
	private ProvinciaDao provinciaDao;

	@Override
	public List<ProvinciaBO> getProvince() throws BusinessException {
		
		List<ProvinciaBO> returnedProvinciaBOList = null;

		try {

			returnedProvinciaBOList = (List<ProvinciaBO>) provinciaDao.getAll();

		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new BusinessException("Error in class " + className + ", method getProvince ");
		}
		return returnedProvinciaBOList;

	}
}

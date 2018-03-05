package com.application.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import com.application.business.BO.ProvinciaBO;
import com.application.dal.dao.ProvinciaDao;

@Stateless
@Transactional
public class ProvinciaBusinessImpl implements ProvinciaBusiness {

	/*
	 * su questo layer possoe effettuare operazioni logiche e qui deve stare la
	 * transazione
	 */

	@Inject
	private transient Logger log;

	@Inject
	private ProvinciaDao provinciaDao;

	@Override
	public List<ProvinciaBO> getProvince() throws Exception {
		
		List<ProvinciaBO> returnedProvinciaBOList = null;

		try {

			returnedProvinciaBOList = (List<ProvinciaBO>) provinciaDao.getAll();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException();
		}
		return returnedProvinciaBOList;

	}
}

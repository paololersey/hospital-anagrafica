package com.application.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import com.application.business.BO.ProdottoBO;
import com.application.dal.dao.ProdottoDao;

@Stateless
@Transactional
public class ProdottoBusinessImpl implements ProdottoBusiness {

	/*
	 * su questo layer possoe effettuare operazioni logiche e qui deve stare la
	 * transazione
	 */

	@Inject
	private transient Logger log;

	@Inject
	private ProdottoDao prodottoDao;

	@Override
	public List<ProdottoBO> getProdotti() throws Exception {
		
		List<ProdottoBO> returnedProdottoBOList = null;

		try {
			returnedProdottoBOList = (List<ProdottoBO>) prodottoDao.getAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException();
		}
		return returnedProdottoBOList;

	}
}

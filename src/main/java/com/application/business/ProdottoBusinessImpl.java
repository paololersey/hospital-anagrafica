package com.application.business;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import org.apache.log4j.Logger;

import com.application.business.BO.ProdottoBO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.dal.dao.ProdottoDao;

@Stateless
@Transactional
public class ProdottoBusinessImpl implements ProdottoBusiness {

	/*
	 * su questo layer possoe effettuare operazioni logiche e qui deve stare la
	 * transazione
	 */

	private static String BL = "BL";
	private static String STANDARD= "STANDARD";
	private static String GIOVANI= "GIOVANI";
	private static String ROSA = "ROSA";
	private static String MONTAGNA = "MONTAGNA";
	
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

	@Override
	public ProdottoBO getProdottoById(Long id) {
		ProdottoBO returnedProdottoBO = null;
		try {
			returnedProdottoBO = prodottoDao.getProdottoById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new WebApplicationException();
		}
		return returnedProdottoBO;
	}

	@Override
	public ProdottoBO getProdottoSuggestion(ClienteWithProdottoTO clienteWithProdottoTO) throws Exception {
		ProdottoBO prodottoBO = null;
		
		/** put the logic here */
		

		if(clienteWithProdottoTO.getCodiceProvincia()!=null && clienteWithProdottoTO.getCodiceProvincia().equals(BL)) {
			prodottoBO = prodottoDao.getByNomeProdotto(MONTAGNA);
			return prodottoBO;
		}
		
		
		if(clienteWithProdottoTO.getSesso()!=null && clienteWithProdottoTO.getSesso().equals("F")) {
			prodottoBO = prodottoDao.getByNomeProdotto(ROSA);
			return prodottoBO;
		}
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(Calendar.YEAR, -30);
		
		if(clienteWithProdottoTO.getDataNascita()!=null && clienteWithProdottoTO.getDataNascita().after(gc.getTime())) {
			prodottoBO = prodottoDao.getByNomeProdotto(GIOVANI);
			return prodottoBO;
		}
		

		prodottoBO = prodottoDao.getByNomeProdotto(STANDARD);
		
		
		return prodottoBO;
	}
}

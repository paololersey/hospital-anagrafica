package com.application.converter;

import com.application.business.BO.ProdottoBO;
import com.application.client.TO.ProdottoTO;
import com.application.dal.entity.Prodotto;
import com.application.exception.ConverterException;

public class ProdottoConverter  {

	/** From BUSINESS layer TO DAL layer and viceversa */

	public ProdottoBO convertEntityToBO(Prodotto prodotto) throws ConverterException{
		ProdottoBO prodottoBO = new ProdottoBO();
		prodottoBO.setId(prodotto.getId());
		prodottoBO.setDescrizioneProdotto(prodotto.getDescrizioneProdotto());
		prodottoBO.setNomeProdotto(prodotto.getNomeProdotto());
		return prodottoBO;
	}

	public Prodotto convertBOToEntity(ProdottoBO prodottoBO) throws ConverterException{
		Prodotto prodotto = new Prodotto();
		prodotto.setId(prodottoBO.getId());
		prodotto.setNomeProdotto(prodottoBO.getNomeProdotto());
		prodotto.setDescrizioneProdotto(prodottoBO.getDescrizioneProdotto());
		return prodotto;
	}

	/** From REST layer TO BUSINESS layer and viceversa */

	public ProdottoTO convertBOtoTO(ProdottoBO prodottoBO) throws ConverterException{
		ProdottoTO prodottoTO = new ProdottoTO();
		prodottoTO.setId(prodottoBO.getId());
		prodottoTO.setNomeProdotto(prodottoBO.getNomeProdotto());
		prodottoTO.setDescrizioneProdotto(prodottoBO.getDescrizioneProdotto());

		return prodottoTO;
	}

	public ProdottoBO convertTOtoBO(ProdottoTO prodottoTO) throws ConverterException {
		ProdottoBO prodottoBO = new ProdottoBO();
		prodottoBO.setId(prodottoTO.getId());
		prodottoBO.setNomeProdotto(prodottoTO.getNomeProdotto());
		prodottoBO.setDescrizioneProdotto(prodottoTO.getDescrizioneProdotto());
		return prodottoBO;
	}

}
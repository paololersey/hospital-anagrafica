package com.application.converter;

import javax.inject.Inject;

import com.application.business.BO.ClienteBO;
import com.application.business.BO.ContoBO;
import com.application.dal.entity.Cliente;
import com.application.dal.entity.Conto;
import com.application.exception.ConverterException;

public class ContoConverter {

	
	@Inject
	private ProdottoConverter prodottoConverter;
	
	/** From BUSINESS layer TO DAL layer and viceversa */

	public ContoBO convertEntityToBO(Conto conto) throws ConverterException {
		ContoBO contoBO = new ContoBO();
		contoBO.setIdConto(conto.getIdConto());
		contoBO.setDataApertura(conto.getDataApertura());
		contoBO.setNumeroContoCorrente(conto.getNumeroContoCorrente());
		contoBO.setProdottoBO(prodottoConverter.convertEntityToBO(conto.getProdotto()));
		return contoBO;
	}

	public Conto convertBOToEntity(ContoBO contoBO) throws ConverterException {
		Conto conto = new Conto();
		conto.setIdConto(contoBO.getIdConto());
		conto.setDataApertura(contoBO.getDataApertura());
		conto.setNumeroContoCorrente(contoBO.getNumeroContoCorrente());
		conto.setProdotto(prodottoConverter.convertBOToEntity(contoBO.getProdottoBO()));
		
		return conto;
	}

	/** From REST layer TO BUSINESS layer and viceversa */
/*
	public ContoTO convertBOtoTO(ContoBO contoBO) {
		ContoTO contoTO = new ContoTO();
		contoTO.setId(contoBO.getId());
		contoTO.setNomeConto(contoBO.getNomeConto());
		contoTO.setDescrizioneConto(contoBO.getDescrizioneConto());

		return contoTO;
	}

	public ContoBO convertTOtoBO(ContoTO contoTO) {
		ContoBO contoBO = new ContoBO();
		contoBO.setId(contoTO.getId());
		contoBO.setNomeConto(contoTO.getNomeConto());
		contoBO.setDescrizioneConto(contoTO.getDescrizioneConto());
		return contoBO;
	}*/

}
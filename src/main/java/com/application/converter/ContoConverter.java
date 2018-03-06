package com.application.converter;

import javax.inject.Inject;

import com.application.business.BO.ClienteBO;
import com.application.business.BO.ContoBO;
import com.application.dal.entity.Cliente;
import com.application.dal.entity.Conto;

public class ContoConverter {

	
	@Inject
	private ProdottoConverter prodottoConverter;
	
	/** From BUSINESS layer TO DAL layer and viceversa */

	public ContoBO convertEntityToBO(Conto conto) {
		ContoBO contoBO = new ContoBO();
		contoBO.setIdConto(conto.getIdConto());
		contoBO.setDataApertura(conto.getDataApertura());
		contoBO.setNumeroContoCorrente(conto.getNumeroContoCorrente());
		contoBO.setProdottoBO(prodottoConverter.convertEntityToBO(conto.getProdotto()));
		ClienteBO clienteBO = new ClienteBO();
//		clienteBO.setId(conto.getCliente().getId());
		contoBO.setClienteBO(clienteBO);	
		return contoBO;
	}

	public Conto convertBOToEntity(ContoBO contoBO) throws Exception {
		Conto conto = new Conto();
		conto.setIdConto(contoBO.getIdConto());
		conto.setDataApertura(contoBO.getDataApertura());
		conto.setNumeroContoCorrente(contoBO.getNumeroContoCorrente());
		conto.setProdotto(prodottoConverter.convertBOToEntity(contoBO.getProdottoBO()));
		//conto.setIdCliente(10L);
		//conto.setIdCliente(10L);
		//Cliente cliente = new Cliente();
		//conto.setCliente(cliente);	
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
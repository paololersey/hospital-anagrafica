package com.application.dal.dao;

import java.util.List;

import com.application.business.BO.ContoBO;
import com.application.business.BO.ProdottoBO;

public interface ProdottoDao {

	public List<ProdottoBO> getAll() throws Exception;

	public ProdottoBO getByNomeProdotto(String nomeProdotto) throws Exception;

	//public ContoBO getContoByIdClienteAndProdotto(Long idCliente, String nomeProdotto) throws Exception;


}

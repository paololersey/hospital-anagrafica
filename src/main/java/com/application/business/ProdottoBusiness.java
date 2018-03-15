package com.application.business;

import java.util.List;

import com.application.business.BO.ProdottoBO;
import com.application.client.TO.ClienteWithProdottoTO;

public interface ProdottoBusiness {

	public List<ProdottoBO> getProdotti() throws Exception;

	public ProdottoBO getProdottoById(Long id);

	public ProdottoBO getProdottoSuggestion(ClienteWithProdottoTO clienteWithProdottoTO) throws Exception;

}

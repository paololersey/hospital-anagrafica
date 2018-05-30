package com.application.business;

import java.util.List;

import com.application.business.BO.ProdottoBO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.exception.BusinessException;

public interface ProdottoBusiness {

	public List<ProdottoBO> getProdotti() throws BusinessException;

	public ProdottoBO getProdottoById(Long id) throws BusinessException;;

	public ProdottoBO getProdottoSuggestion(ClienteWithProdottoTO clienteWithProdottoTO) throws BusinessException;

}

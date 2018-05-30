package com.application.business;

import java.util.List;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;
import com.application.exception.BusinessException;

public interface ClienteProdottoBusiness {

	public ClienteBO saveCliente(ClienteBO clienteBO) throws BusinessException;

	public List<ClienteBO> getClientiWithProdotto(ClienteWithProdottoSearch clienteWithProdottoSearch)
			throws BusinessException;

	public Long deleteCliente(Long id) throws BusinessException;

}

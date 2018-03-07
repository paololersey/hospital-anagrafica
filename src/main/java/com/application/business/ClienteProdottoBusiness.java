package com.application.business;

import java.util.List;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;

public interface ClienteProdottoBusiness {

	public ClienteBO saveCliente(ClienteBO clienteBO) throws Exception;

	public List<ClienteBO> getClientiWithProdotto(ClienteWithProdottoSearch clienteWithProdottoSearch);

	public Long deleteCliente(Long id);

}

package com.application.business;

import java.util.List;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;

public interface ClienteProdottoBusiness {

	ClienteBO saveCliente(ClienteBO clienteBO) throws Exception;

	List<ClienteBO> getClientiWithProdotto(ClienteWithProdottoSearch clienteWithProdottoSearch);

}

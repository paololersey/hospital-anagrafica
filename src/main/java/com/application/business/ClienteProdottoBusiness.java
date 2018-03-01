package com.application.business;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoTO;

public interface ClienteProdottoBusiness {

	ClienteBO saveCliente(ClienteBO clienteBO) throws Exception;

}

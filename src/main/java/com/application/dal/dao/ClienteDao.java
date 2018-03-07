package com.application.dal.dao;

import java.util.List;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;
import com.application.dal.entity.Cliente;

public interface ClienteDao {

	public ClienteBO save(ClienteBO clienteBO) throws Exception;

	public List<Cliente> getAll() throws Exception;

	public ClienteBO saveOpeningAndClosingSession(ClienteBO clienteBO) throws Exception;

	public ClienteBO merge(ClienteBO clienteBO) throws Exception;

	public List<ClienteBO> getClienti(ClienteWithProdottoSearch clienteWithProdottoSearch) throws Exception;

	public Long delete(ClienteBO clienteBO) throws Exception;

	public ClienteBO getClienteById(Long id) throws Exception;



}

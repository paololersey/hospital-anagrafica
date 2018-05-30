package com.application.dal.dao;

import java.util.List;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoSearch;
import com.application.dal.entity.Cliente;
import com.application.exception.DaoException;

public interface ClienteDao {

	public ClienteBO save(ClienteBO clienteBO) throws DaoException;

	public List<Cliente> getAll() throws DaoException;

	public ClienteBO saveOpeningAndClosingSession(ClienteBO clienteBO) throws DaoException;

	public ClienteBO merge(ClienteBO clienteBO) throws DaoException;

	public List<ClienteBO> getClienti(ClienteWithProdottoSearch clienteWithProdottoSearch) throws DaoException;

	public Long delete(ClienteBO clienteBO) throws DaoException;

	public ClienteBO getClienteById(Long id) throws DaoException;



}

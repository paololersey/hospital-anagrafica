package com.application.dal.dao;

import com.application.business.BO.ClienteBO;
import com.application.dal.entity.Cliente;

public interface ClienteDao {

	public ClienteBO save(ClienteBO clienteBO) throws Exception;

	public Cliente getAll() throws Exception;


}

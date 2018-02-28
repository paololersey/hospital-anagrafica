package com.application.dal.dao;

import com.application.dal.model.Cliente;

public interface ClienteDao {

	public Cliente save(Cliente customer) throws Exception;

	public Cliente getAll(Cliente customer) throws Exception;

}

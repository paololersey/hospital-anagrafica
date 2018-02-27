package com.application.dal.dao;

import com.application.dal.model.Customer;

public interface ClienteDao {

	public Customer save(Customer customer) throws Exception;

	public Customer getAll(Customer customer) throws Exception;

}

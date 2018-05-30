package com.application.dal.dao;

import java.util.List;

import com.application.business.BO.ProvinciaBO;
import com.application.exception.DaoException;

public interface ProvinciaDao {

	public List<ProvinciaBO> getAll() throws DaoException;

	public ProvinciaBO getByCodice(String codice) throws DaoException;
}

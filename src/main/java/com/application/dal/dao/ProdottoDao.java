package com.application.dal.dao;

import java.util.List;

import com.application.business.BO.ProdottoBO;
import com.application.exception.DaoException;

public interface ProdottoDao {

	public List<ProdottoBO> getAll() throws DaoException;

	public ProdottoBO getByNomeProdotto(String nomeProdotto) throws DaoException;

	public ProdottoBO getProdottoById(Long id) throws DaoException;


}

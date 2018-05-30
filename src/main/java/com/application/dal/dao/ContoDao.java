package com.application.dal.dao;

import com.application.business.BO.ContoBO;
import com.application.exception.DaoException;

public interface ContoDao {

	public ContoBO getContoByIdCliente(Long idCliente) throws DaoException;

}

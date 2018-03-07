package com.application.dal.dao;

import com.application.business.BO.ContoBO;

public interface ContoDao {

	public ContoBO getContoByIdCliente(Long idCliente) throws Exception;

}

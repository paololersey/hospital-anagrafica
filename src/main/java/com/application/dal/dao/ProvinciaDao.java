package com.application.dal.dao;

import java.util.List;

import com.application.business.BO.ProvinciaBO;
import com.application.dal.entity.Provincia;

public interface ProvinciaDao {

	public List<ProvinciaBO> getAll() throws Exception;


}

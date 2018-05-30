package com.application.business;

import java.util.List;

import com.application.business.BO.ProvinciaBO;
import com.application.exception.BusinessException;

public interface ProvinciaBusiness {

	List<ProvinciaBO> getProvince() throws BusinessException;

}

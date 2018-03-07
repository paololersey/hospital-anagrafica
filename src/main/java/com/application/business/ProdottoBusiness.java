package com.application.business;

import java.util.List;

import com.application.business.BO.ProdottoBO;

public interface ProdottoBusiness {

	public List<ProdottoBO> getProdotti() throws Exception;

	public ProdottoBO getProdottoById(Long id);

}

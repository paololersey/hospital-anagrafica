package com.application.converter;

import com.application.business.BO.ProvinciaBO;
import com.application.client.TO.ProvinciaTO;
import com.application.dal.entity.Provincia;
import com.application.exception.ConverterException;

public class ProvinciaConverter {

	/** From BUSINESS layer TO DAL layer and viceversa */

	public ProvinciaBO convertEntityToBO(Provincia provincia) throws ConverterException{
		ProvinciaBO provinciaBO = new ProvinciaBO();
		provinciaBO.setId(provincia.getId());
		provinciaBO.setCodice(provincia.getCodice());
		provinciaBO.setDescrizione(provincia.getDescrizione());
		return provinciaBO;
	}

	public Provincia convertBOToEntity(ProvinciaBO provinciaBO) throws ConverterException {
		Provincia provincia = new Provincia();
		provincia.setId(provinciaBO.getId());
		provincia.setCodice(provinciaBO.getCodice());
		provincia.setDescrizione(provinciaBO.getDescrizione());
		return provincia;
	}

	/** From REST layer TO BUSINESS layer and viceversa */

	public ProvinciaTO convertBOtoTO(ProvinciaBO provinciaBO) throws ConverterException {
		ProvinciaTO provinciaTO = new ProvinciaTO();
		provinciaTO.setId(provinciaBO.getId());
		provinciaTO.setCodice(provinciaBO.getCodice());
		provinciaTO.setDescrizione(provinciaBO.getDescrizione());

		return provinciaTO;
	}

	public ProvinciaBO convertTOtoBO(ProvinciaTO provinciaTO) throws ConverterException {
		ProvinciaBO provinciaBO = new ProvinciaBO();
		provinciaBO.setId(provinciaTO.getId());
		provinciaBO.setCodice(provinciaTO.getCodice());
		provinciaBO.setDescrizione(provinciaTO.getDescrizione());
		return provinciaBO;
	}

}
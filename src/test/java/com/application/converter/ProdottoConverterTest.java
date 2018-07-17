package com.application.converter;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.application.client.TO.ProdottoTO;
import com.application.exception.ConverterException;

public class ProdottoConverterTest {

	private ProdottoConverter prodottoConverter;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// do nothing
	}
	
	@Before
	public void setUp() throws Exception {
		prodottoConverter = new ProdottoConverter();
	}

	@Test
	public void testConvertTOtoBO() throws ConverterException {
		ProdottoTO prodottoTO = new ProdottoTO();
		prodottoTO.setId(100L);
		prodottoTO.setNomeProdotto("NOME_PRODOTTO");
		prodottoTO.setDescrizioneProdotto("DESCRIZIONE_PRODOTTO");
		
		// test returned object not null
		assertNotNull(prodottoConverter.convertTOtoBO(prodottoTO));
	}

}

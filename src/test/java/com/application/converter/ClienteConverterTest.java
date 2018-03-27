package com.application.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.application.client.TO.ClienteWithProdottoTO;

@RunWith(MockitoJUnitRunner.class)
public class ClienteConverterTest {

	@Mock
	private ProvinciaConverter provinciaConverter;
	
	@Mock
	private ProdottoConverter prodottoConverter;
	
	@Mock
	private ContoConverter contoConverter;
	
	@InjectMocks
	private ClienteConverter clienteConverter;
	
	@Test
	public void testConvertTOtoBO() {
		ClienteWithProdottoTO clienteWithProdottoTO = new ClienteWithProdottoTO();
		clienteWithProdottoTO.setId(1L);
		clienteWithProdottoTO.setCognome("COGNOME");
		clienteWithProdottoTO.setNome("NOME");
		clienteWithProdottoTO.setCodiceFiscale("CODICE_FISCALE");
		clienteWithProdottoTO.setSesso("M");
		clienteWithProdottoTO.setDataNascita(new Date());
		
		try {
			// test returned object not null
			assertNotNull(clienteConverter.convertTOtoBO(clienteWithProdottoTO));
		} catch (Exception e) {
			// test failed
			fail("test ended in error due to an internal exception");
		}
	}

}

package com.application.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.application.dal.entity.Cliente;
import com.application.dal.entity.Provincia;

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
	
	@BeforeClass
	public static void setUp() throws Exception {
		// do nothing
	}
	
	@Test
	public void testConvertEntityToBO() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setCognome("COGNOME");
		cliente.setNome("NOME");
		cliente.setCodiceFiscale("CODICE_FISCALE");
		cliente.setSesso("M");
		cliente.setDataNascita(new Date());
		cliente.setDataFine(new Date());
		
		Provincia provincia = new Provincia();
		provincia.setId(100L);
		provincia.setCodice("PD");
		provincia.setDescrizione("PADOVA");
		cliente.setProvincia(provincia);
		
		cliente.setContiList(new HashSet<>());
		
		try {
			assertNotNull(clienteConverter.convertEntityToBO(cliente));
		} catch (Exception e) {
			// test failed
			fail("test endend in error due to an internal exception");
		}
	}

}

package com.application.converter;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.application.business.BO.ClienteBO;
import com.application.business.BO.ContoBO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.client.TO.ProdottoTO;
import com.application.client.TO.ProvinciaTO;
import com.application.dal.entity.Cliente;
import com.application.dal.entity.Conto;
import com.application.exception.ConverterException;

public class ClienteConverter {

	private static String className = ClienteConverter.class.getName();

	@Inject
	private ProvinciaConverter provinciaConverter;

	@Inject
	private ProdottoConverter prodottoConverter;

	@Inject
	private ContoConverter contoConverter;

	@Inject
	private transient Logger log;

	/** From BUSINESS layer TO DAL layer and viceversa */

	public ClienteBO convertEntityToBO(Cliente cliente) throws ConverterException {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.setId(cliente.getId());
		clienteBO.setDataNascita(cliente.getDataNascita());
		clienteBO.setDataFine(cliente.getDataFine());
		clienteBO.setCodiceFiscale(cliente.getCodiceFiscale());
		clienteBO.setNome(cliente.getNome());
		clienteBO.setCognome(cliente.getCognome());
		clienteBO.setSesso(cliente.getSesso());
		try {
			clienteBO.setProvinciaBO(provinciaConverter.convertEntityToBO(cliente.getProvincia()));
			for (Conto conto : cliente.getContiList()) {
				ContoBO contoBO = contoConverter.convertEntityToBO(conto);
				clienteBO.addContoBO(contoBO);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ConverterException("Error in class " + className + ", method convertEntityToBO, exception" + e);
		}

		return clienteBO;
	}

	public Cliente convertBOToEntity(ClienteBO clienteBO) throws ConverterException {
		Cliente cliente = new Cliente();
		cliente.setId(clienteBO.getId());
		cliente.setDataNascita(clienteBO.getDataNascita());
		cliente.setDataFine(clienteBO.getDataFine());
		cliente.setCodiceFiscale(clienteBO.getCodiceFiscale());
		cliente.setNome(clienteBO.getNome());
		cliente.setCognome(clienteBO.getCognome());
		cliente.setSesso(clienteBO.getSesso());
		try {
			cliente.setProvincia(provinciaConverter.convertBOToEntity(clienteBO.getProvinciaBO()));
			for (ContoBO contoBO : clienteBO.getContoBOList()) {
				Conto conto = contoConverter.convertBOToEntity(contoBO);
				cliente.addConto(conto);
			}
		} catch (ConverterException e) {
			log.error(e.getMessage());
			throw new ConverterException("Error in class " + className + ", method convertBOToEntity, exception" + e);
		}

		return cliente;
	}

	/** From REST layer TO BUSINESS layer and viceversa */

	/** usato al ritorno della ricerca principale */
	
	public ClienteWithProdottoTO convertBOtoTO(ClienteBO clienteBO) throws ConverterException{
		ClienteWithProdottoTO clienteTO = new ClienteWithProdottoTO();
		clienteTO.setId(clienteBO.getId());
		clienteTO.setDataNascita(clienteBO.getDataNascita());
		clienteTO.setCodiceFiscale(clienteBO.getCodiceFiscale());
		clienteTO.setNome(clienteBO.getNome());
		clienteTO.setCognome(clienteBO.getCognome());
		clienteTO.setSesso(clienteBO.getSesso());
		clienteTO.setNomeProdotto(clienteBO.getNomeProdotto());
		clienteTO.setCodiceProvincia(clienteBO.getCodiceProvincia());

		if (clienteBO.getProvinciaBO() != null) {
			ProvinciaTO provinciaTO = provinciaConverter.convertBOtoTO(clienteBO.getProvinciaBO());
			clienteTO.setCodiceProvincia(provinciaTO.getCodice());
		}

		if (clienteBO.getContoBOList() != null && clienteBO.getContoBOList().size() == 1) {
			ContoBO contoBO = new ArrayList<>(clienteBO.getContoBOList()).get(0);
			ProdottoTO prodottoTO = prodottoConverter.convertBOtoTO(contoBO.getProdottoBO());
			clienteTO.setNomeProdotto(prodottoTO.getNomeProdotto());
		}

		return clienteTO;
	}
	
	

	public ClienteBO convertTOtoBO(ClienteWithProdottoTO clienteWithProdottoTO) throws ConverterException{

		ClienteBO clienteBO = new ClienteBO();
		clienteBO.setId(clienteWithProdottoTO.getId());
		clienteBO.setDataNascita(clienteWithProdottoTO.getDataNascita());
		clienteBO.setCodiceFiscale(clienteWithProdottoTO.getCodiceFiscale());
		clienteBO.setNome(clienteWithProdottoTO.getNome());
		clienteBO.setCognome(clienteWithProdottoTO.getCognome());
		clienteBO.setSesso(clienteWithProdottoTO.getSesso());
		clienteBO.setNomeProdotto(clienteWithProdottoTO.getNomeProdotto());
		clienteBO.setCodiceProvincia(clienteWithProdottoTO.getCodiceProvincia());

		return clienteBO;
	}

}
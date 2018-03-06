package com.application.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.application.business.BO.ClienteBO;
import com.application.business.BO.ContoBO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.dal.entity.Cliente;
import com.application.dal.entity.Conto;

public class ClienteConverter {

	private static String className = ClienteConverter.class.getName();
	
	@Inject
	private ProvinciaConverter provinciaConverter;
	
	@Inject
	private ContoConverter contoConverter;
	
	@Inject
	private transient Logger log;


	/** From BUSINESS layer TO DAL layer and viceversa */

	public ClienteBO convertEntityToBO(Cliente cliente) throws Exception{
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.setId(cliente.getId());
		clienteBO.setDataNascita(cliente.getDataNascita());
		clienteBO.setCodiceFiscale(cliente.getCodiceFiscale());
		clienteBO.setNome(cliente.getNome());
		clienteBO.setCognome(cliente.getCognome());
		clienteBO.setSesso(cliente.getSesso());
		try {
			clienteBO.setProvinciaBO(provinciaConverter.convertEntityToBO(cliente.getProvincia()));
			Set<ContoBO> contoBOList = new HashSet<>();
//			for(Conto conto: cliente.getContiList()) {
//				ContoBO contoBO = contoConverter.convertEntityToBO(conto);
//				contoBOList.add(contoBO);
//			}
			//clienteBO.setContoBOList(contoBOList);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Error in class " + className + ", method convertEntityToBO, exception" + e);
		}
		
		return clienteBO;
	}

	public Cliente convertBOToEntity(ClienteBO clienteBO) throws Exception{
		Cliente cliente = new Cliente();
		cliente.setId(clienteBO.getId());
		cliente.setDataNascita(clienteBO.getDataNascita());
		cliente.setCodiceFiscale(clienteBO.getCodiceFiscale());
		cliente.setNome(clienteBO.getNome());
		cliente.setCognome(clienteBO.getCognome());
		cliente.setSesso(clienteBO.getSesso());
		try {
			cliente.setProvincia(provinciaConverter.convertBOToEntity(clienteBO.getProvinciaBO()));
			Set<Conto> contiList = new HashSet<>();
			for(ContoBO contoBO: clienteBO.getContoBOList()) {
				Conto conto = contoConverter.convertBOToEntity(contoBO);
				contiList.add(conto);	
			}
			cliente.setContiList(new ArrayList<>(contiList));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Error in class " + className + ", method convertBOToEntity, exception" + e);
		}
		
		
		return cliente;
	}

	/** From REST layer TO BUSINESS layer and viceversa */

	public ClienteWithProdottoTO convertBOtoTO(ClienteBO clienteBO) {
		ClienteWithProdottoTO clienteTO = new ClienteWithProdottoTO();
		clienteTO.setDataNascita(clienteBO.getDataNascita());
		clienteTO.setCodiceFiscale(clienteBO.getCodiceFiscale());
		clienteTO.setNome(clienteBO.getNome());
		clienteTO.setCognome(clienteBO.getCognome());
		clienteTO.setSesso(clienteBO.getSesso());
		clienteTO.setNomeProdotto(clienteBO.getNomeProdotto());
		clienteTO.setCodiceProvincia(clienteBO.getCodiceProvincia());
		
		return clienteTO;
	}

	public ClienteBO convertTOtoBO(ClienteWithProdottoTO clienteWithProdottoTO) {
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
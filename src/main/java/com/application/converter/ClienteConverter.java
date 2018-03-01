package com.application.converter;

import com.application.business.BO.ClienteBO;
import com.application.client.TO.ClienteWithProdottoTO;
import com.application.dal.entity.Cliente;

public class ClienteConverter {

	 /** From BUSINESS layer TO DAL layer and viceversa */ 

		public ClienteBO convertEntityToBO(Cliente cliente) {
			ClienteBO clienteBO = new ClienteBO();
			clienteBO.setId(cliente.getId());
			clienteBO.setDataNascita(cliente.getDataNascita());
			clienteBO.setCodiceFiscale(cliente.getCodiceFiscale());
			clienteBO.setNome(cliente.getNome());
			clienteBO.setCognome(cliente.getCognome());
			clienteBO.setSesso(cliente.getSesso());
			return clienteBO; 		
		}
		
		public Cliente convertBOToEntity(ClienteBO clienteBO) {
			Cliente cliente = new Cliente();
			cliente.setDataNascita(clienteBO.getDataNascita());
			cliente.setCodiceFiscale(clienteBO.getCodiceFiscale());
			cliente.setNome(clienteBO.getNome());
			cliente.setCognome(clienteBO.getCognome());
			cliente.setSesso(clienteBO.getSesso());
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
			clienteTO.setDescProdotto("PRODOTTO");
			clienteTO.setProvincia("BO");
			return clienteTO; 		
		}
		
		public ClienteBO convertTOtoBO(ClienteWithProdottoTO clienteWithProdottoTO) {
			ClienteBO clienteBO = new ClienteBO();
			clienteBO.setDataNascita(clienteWithProdottoTO.getDataNascita());
			clienteBO.setCodiceFiscale(clienteWithProdottoTO.getCodiceFiscale());
			clienteBO.setNome(clienteWithProdottoTO.getNome());
			clienteBO.setCognome(clienteWithProdottoTO.getCognome());
			clienteBO.setSesso(clienteWithProdottoTO.getSesso());
			return clienteBO; 		
		}

		
	
}
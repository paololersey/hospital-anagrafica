package com.application.business.BO;

import java.util.Date;

import com.application.dal.entity.Cliente;
import com.application.dal.entity.Prodotto;

public class ContoBO implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long idConto;
	private String numeroContoCorrente;
	private Date dataApertura;
	private ProdottoBO prodottoBO;
	private ClienteBO clienteBO;

	
	public ContoBO() {
	}

	public Long getIdConto() {
		return idConto;
	}

	public void setIdConto(Long idConto) {
		this.idConto = idConto;
	}

	public String getNumeroContoCorrente() {
		return numeroContoCorrente;
	}

	public void setNumeroContoCorrente(String numeroContoCorrente) {
		this.numeroContoCorrente = numeroContoCorrente;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	public ProdottoBO getProdottoBO() {
		return prodottoBO;
	}

	public void setProdottoBO(ProdottoBO prodottoBO) {
		this.prodottoBO = prodottoBO;
	}

	public ClienteBO getClienteBO() {
		return clienteBO;
	}

	public void setClienteBO(ClienteBO clienteBO) {
		this.clienteBO = clienteBO;
	}

	

}

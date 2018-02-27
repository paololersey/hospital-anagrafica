package com.application.client.TO;

public class ContoCorrenteTO implements java.io.Serializable {

	private static final long serialVersionUID = 8523982493289566025L;

	private String numContoCorrente;
	private String descProdotto;
	private String nomeCognomeCliente;

	public ContoCorrenteTO() {

	}


	public String getNumContoCorrente() {
		return numContoCorrente;
	}

	public void setNumContoCorrente(String numContoCorrente) {
		this.numContoCorrente = numContoCorrente;
	}

	public String getDescProdotto() {
		return descProdotto;
	}

	public void setDescProdotto(String descProdotto) {
		this.descProdotto = descProdotto;
	}

	public String getNomeCognomeCliente() {
		return nomeCognomeCliente;
	}

	public void setNomeCognomeCliente(String nomeCognomeCliente) {
		this.nomeCognomeCliente = nomeCognomeCliente;
	}


}

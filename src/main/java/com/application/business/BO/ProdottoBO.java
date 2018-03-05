package com.application.business.BO;

public class ProdottoBO implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long idProdotto;
	private String nomeProdotto;
	private String descrizioneProdotto;
	
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}
	public void setDescrizioneProdotto(String descrizione) {
		this.descrizioneProdotto = descrizione;
	}
	public Long getId() {
		return idProdotto;
	}
	public void setId(Long idProdotto) {
		this.idProdotto = idProdotto;
	}
}

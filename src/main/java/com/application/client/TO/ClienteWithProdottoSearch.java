package com.application.client.TO;

import java.util.Date;

public class ClienteWithProdottoSearch implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private String sesso;
	private String provincia;
	private String descProdotto;
	private String numContoCorrente;

	public ClienteWithProdottoSearch() {

	}

	public ClienteWithProdottoSearch(String nome, String cognome, Date dataNascita, String codiceFiscale,
			String sesso, String provincia, String descProdotto, String numContoCorrente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.sesso = sesso;
		this.provincia = provincia;
		this.descProdotto = descProdotto;
		this.numContoCorrente = numContoCorrente;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDescProdotto() {
		return descProdotto;
	}

	public void setDescProdotto(String descProdotto) {
		this.descProdotto = descProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	

	public String getNumContoCorrente() {
		return numContoCorrente;
	}

	public void setNumContoCorrente(String numContoCorrente) {
		this.numContoCorrente = numContoCorrente;
	}

	@Override
	public String toString() {
		return "ClienteWithProdottoTO [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", sesso=" + sesso + ", provincia=" + provincia + ", descProdotto=" + descProdotto + "]";
	}

}

package com.application.client.TO;

import java.util.Date;

public class ClienteWithProdottoTO implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private String nome;
	private String cognome;
	private Date dataNascita;
	private String sesso;
	private String provincia;
	private String codiceFiscale;
	private String descProdotto;

	public ClienteWithProdottoTO() {

	};

	public ClienteWithProdottoTO(String nome, String cognome, Date dataNascita, String sesso, String provincia,
			String codiceFiscale, String descProdotto) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.provincia = provincia;
		this.codiceFiscale = codiceFiscale;
		this.descProdotto = descProdotto;
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

	
	@Override
	public String toString() {
		return "ClienteWithProdottoTO [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", sesso=" + sesso + ", provincia=" + provincia + ", descProdotto=" + descProdotto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result + ((descProdotto == null) ? 0 : descProdotto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteWithProdottoTO other = (ClienteWithProdottoTO) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (descProdotto == null) {
			if (other.descProdotto != null)
				return false;
		} else if (!descProdotto.equals(other.descProdotto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		return true;
	}

}

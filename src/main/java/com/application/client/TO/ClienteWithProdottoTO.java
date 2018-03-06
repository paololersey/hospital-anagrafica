package com.application.client.TO;

import java.util.Date;

public class ClienteWithProdottoTO implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String sesso;
	private String codiceProvincia;
	private String codiceFiscale;
	private String nomeProdotto;

	public ClienteWithProdottoTO() {

	};

	public ClienteWithProdottoTO(Long id, String nome, String cognome, Date dataNascita, String sesso, String codiceProvincia,
			String codiceFiscale, String nomeProdotto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.codiceProvincia = codiceProvincia;
		this.codiceFiscale = codiceFiscale;
		this.nomeProdotto = nomeProdotto;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCodiceProvincia() {
		return codiceProvincia;
	}

	public void setCodiceProvincia(String codiceProvincia) {
		this.codiceProvincia = codiceProvincia;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
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
		return "ClienteWithProdottoTO [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", sesso=" + sesso + ", codiceProvincia=" + codiceProvincia + ", codiceFiscale="
				+ codiceFiscale + ", nomeProdotto=" + nomeProdotto + "]";
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
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (codiceProvincia == null) {
			if (other.codiceProvincia != null)
				return false;
		} else if (!codiceProvincia.equals(other.codiceProvincia))
			return false;
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
		if (nomeProdotto == null) {
			if (other.nomeProdotto != null)
				return false;
		} else if (!nomeProdotto.equals(other.nomeProdotto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		return true;
	}

	
	


}

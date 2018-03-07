package com.application.business.BO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.application.dal.entity.Conto;


public class ClienteBO implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String sesso;
	private Date dataNascita;
	private String codiceProvincia;
	private String nomeProdotto;
	private ProvinciaBO provinciaBO;
	private Set<ContoBO> contoBOList = new HashSet<>();

	public ClienteBO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getCodiceProvincia() {
		return codiceProvincia;
	}

	public void setCodiceProvincia(String codiceProvincia) {
		this.codiceProvincia = codiceProvincia;
	}

	public ProvinciaBO getProvinciaBO() {
		return provinciaBO;
	}

	public void setProvinciaBO(ProvinciaBO provinciaBO) {
		this.provinciaBO = provinciaBO;
	}
	
	public Set<ContoBO> getContoBOList() {
		return contoBOList;
	}

	public void setContoBOList(Set<ContoBO> contoBOList) {
		this.contoBOList = contoBOList;
	}
	
	public void addContoBO(ContoBO contoBO) {
		this.contoBOList.add(contoBO);
		contoBO.setClienteBO(this);
	}

}

package com.application.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODOTTO")
public class Prodotto implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long idProdotto;
	private String nomeProdotto;
	private String descrizioneProdotto;

	public Prodotto() {
	}

	public Prodotto(Long idProdotto, String nomeProdotto, String descrizioneProdotto) {
		super();
		this.idProdotto = idProdotto;
		this.nomeProdotto = nomeProdotto;
		this.descrizioneProdotto = descrizioneProdotto;
	}

	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_prodotto")
	@SequenceGenerator(name = "gen_prodotto", sequenceName = "SEQ_PRODOTTO", initialValue = 1, allocationSize = 1)
	@Id
	@Column(name = "ID_PRODOTTO", length = 19, nullable = false)
	public Long getId() {
		return idProdotto;
	}

	public void setId(Long idProdotto) {
		this.idProdotto = idProdotto;
	}

	@Column(name = "NOME_PRODOTTO", length = 10)
	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	@Column(name = "DESCRIZIONE_PRODOTTO", length = 100)
	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

}

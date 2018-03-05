package com.application.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCIA")
public class Provincia implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long id;
	private String codice;
	private String descrizione;

	public Provincia() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_provincia")
	@SequenceGenerator(name = "gen_provincia", sequenceName = "SEQ_PROVINCIA", initialValue = 1, allocationSize = 1)
	@Id
	@Column(name = "ID_PROVINCIA", length = 19, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODICE", length = 2)
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Column(name = "DESCRIZIONE", length = 100)
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}

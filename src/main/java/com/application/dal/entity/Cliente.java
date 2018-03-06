package com.application.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String sesso;
	private Date dataNascita;
	private Provincia provincia;
	private List<Conto> contiList = new ArrayList<>();

	public Cliente() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_cliente")
	@SequenceGenerator(name = "gen_cliente", sequenceName = "SEQ_CLIENTE", initialValue = 1, allocationSize = 1)
	@Id
	@Column(name = "ID_CLIENTE", length = 19, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NOME", length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "COGNOME", length = 100)
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Column(name = "CODICE_FISCALE", length = 16)
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Column(name = "SESSO", length = 1)
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	@Column(name = "DATA_NASCITA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PROVINCIA")
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

//	@OneToMany
//	@JoinColumn(name = "ID_CLIENTE", referencedColumnName="ID_CLIENTE")
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Conto> getContiList() {
		return contiList;
	}

	public void setContiList(List<Conto> contiList) {
		this.contiList = contiList;
	}

}

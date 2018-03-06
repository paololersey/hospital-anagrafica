package com.application.dal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONTO")
public class Conto implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long idConto;
	private String numeroContoCorrente;
	private Date dataApertura;
	private Prodotto prodotto;
	//private Long idCliente;
	private Cliente cliente;
	


	public Conto() {
	}

	
	
	public Conto(Long idConto, String numeroContoCorrente, Date dataApertura, Prodotto prodotto/*, Long idCliente*/) {
		super();
		this.idConto = idConto;
		this.numeroContoCorrente = numeroContoCorrente;
		this.dataApertura = dataApertura;
		this.prodotto = prodotto;
		//this.idCliente = idCliente;
	}



	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_conto")
	@SequenceGenerator(name = "gen_conto", sequenceName = "SEQ_CONTO", initialValue = 1, allocationSize = 1)
	@Id
	@Column(name = "ID_CONTO", length = 19, nullable = false)
	public Long getIdConto() {
		return idConto;
	}

	public void setIdConto(Long idConto) {
		this.idConto = idConto;
	}

	@Column(name = "NUMERO_CONTO_CORRENTE", length = 100)
	public String getNumeroContoCorrente() {
		return numeroContoCorrente;
	}

	public void setNumeroContoCorrente(String numeroContoCorrente) {
		this.numeroContoCorrente = numeroContoCorrente;
	}


	@Column(name = "DT_APERTURA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PRODOTTO")
	public Prodotto getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

//	@ManyToOne(fetch = FetchType.LAZY) 
//	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
	
	@ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
//
//	@Column(name = "ID_CLIENTE", insertable=false, updatable=false)
//	public Long getIdCliente() {
//		return idCliente;
//	}
//
//	public void setIdCliente(Long idCliente) {
//		this.idCliente = idCliente;
//	}

}

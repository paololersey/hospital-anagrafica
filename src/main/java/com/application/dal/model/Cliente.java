package com.application.dal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private Long id;
	private String name;
	private String surname;
	private String fiscalCode;
	private Date dateOfBirth;
	private Date insertDate;

	public Cliente() {
	}

	public Cliente(Long id, String name, String surname, String fiscalCode, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.fiscalCode = fiscalCode;
		this.dateOfBirth = dateOfBirth;
	}

	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_customer")
	@SequenceGenerator(name = "gen_customer", sequenceName = "SEQ_CUSTOMER", initialValue = 1, allocationSize = 1)
	@Id
	@Column(name = "ID", length = 19, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME", length = 100)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "FISCAL_CODE", length = 16)
	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	@Column(name = "DATE_OF_BIRTH", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "INSERT_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}

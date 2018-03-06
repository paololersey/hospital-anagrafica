package com.application.client.TO;

public class ContoCorrenteSearchTO implements java.io.Serializable {

	private static final long serialVersionUID = 8539824932895066025L;

	private String descrizione;
	private String numContoCorrente;
	private String idProdotto;
	private String idCliente;


	@Override
	public String toString() {
		return "ContoCorrenteSearchTO [descrizione=" + descrizione + ", numContoCorrente=" + numContoCorrente
				+ ", idProdotto=" + idProdotto + ", idCliente=" + idCliente + "]";
	}

	public ContoCorrenteSearchTO() {

	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNumContoCorrente() {
		return numContoCorrente;
	}

	public void setNumContoCorrente(String numContoCorrente) {
		this.numContoCorrente = numContoCorrente;
	}

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


}

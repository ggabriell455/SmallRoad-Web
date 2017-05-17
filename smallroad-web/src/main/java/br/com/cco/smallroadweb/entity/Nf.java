package br.com.cco.smallroadweb.entity;

import java.util.Date;

public class Nf {

	private int id;
	private int numero;
	private int cepOrigem;
	private int endOrigem;
	private String cepDestino;
	private String endDestino;
	private double distancia;
	private Date dtEntrega;

	public Nf() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(int cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public int getEndOrigem() {
		return endOrigem;
	}

	public void setEndOrigem(int endOrigem) {
		this.endOrigem = endOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getEndDestino() {
		return endDestino;
	}

	public void setEndDestino(String endDestino) {
		this.endDestino = endDestino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Date getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	@Override
	public String toString() {
		return "Nf [id=" + id + ", numero=" + numero + ", cepOrigem=" + cepOrigem + ", endOrigem=" + endOrigem
				+ ", cepDestino=" + cepDestino + ", endDestino=" + endDestino + ", distancia=" + distancia
				+ ", dtEntrega=" + dtEntrega + "]";
	}
	
	

}

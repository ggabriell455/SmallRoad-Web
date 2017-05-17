package br.com.cco.smallroadweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nf")
public class Nf {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="numero", unique=true, nullable=false)
	private int numero;
	
	@Column(name="cep_origem")
	private int cepOrigem;
	
	@Column(name="end_origem")
	private int endOrigem;
	
	@Column(name="cep_destino")
	private String cepDestino;
	
	@Column(name="end_destino")
	private String endDestino;
	
	@Column(name="distancia")
	private double distancia;
	
	@Column(name="dt_entrega")
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

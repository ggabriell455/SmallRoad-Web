package br.com.cco.smallroadweb.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nf")
public class Nf {

	@Id
	@Column(name="numero", unique=true, nullable=false)
	private Integer numero;
	
	@Column(name="cep_origem")
	private Integer cepOrigem;
	
	@Column(name="end_origem")
	private String endOrigem;
	
	@Column(name="cep_destino")
	private Integer cepDestino;
	
	@Column(name="end_destino")
	private String endDestino;
	
	@Column(name="distancia")
	private Double distancia;
	
	@Column(name="dt_entrega")
	private Date dtEntrega;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roteiro_id")
	private Roteiro roteiro;
	

	public Nf() {
		
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

	public String getEndOrigem() {
		return endOrigem;
	}

	public void setEndOrigem(String endOrigem) {
		this.endOrigem = endOrigem;
	}

	public Integer getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(Integer cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getEndDestino() {
		return endDestino;
	}

	public void setEndDestino(String endDestino) {
		this.endDestino = endDestino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
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
		return "Nf [numero=" + numero + ", cepOrigem=" + cepOrigem + ", endOrigem=" + endOrigem
				+ ", cepDestino=" + cepDestino + ", endDestino=" + endDestino + ", distancia=" + distancia
				+ ", dtEntrega=" + dtEntrega + "]";
	}
	
	

}

package br.com.cco.smallroadweb.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nf")
public class Nf {

	@Id
	@Column(name = "numero", unique = true, nullable = false)
	private Integer numero;

	@Column(name = "cep_origem")
	private String cepOrigem;

	@Column(name = "end_origem")
	private String endOrigem;

	@Column(name = "cep_destino")
	private String cepDestino;

	@Column(name = "end_destino")
	private String endDestino;

	@Column(name = "distancia")
	public BigDecimal distancia;

	@Column(name = "entregue")
	private String entregue;

	@ManyToOne
	@JoinColumn(name = "roteiro_id")
	private Roteiro roteiro;

	public Nf() {

	}

	public Nf(Integer numero, String endDestino) {
		this.numero = numero;
		this.endDestino = endDestino;
		this.cepOrigem = "54000-000";
		this.endOrigem = "Faculdade dos Guararapes";
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getEndOrigem() {
		return endOrigem;
	}

	public void setEndOrigem(String endOrigem) {
		this.endOrigem = endOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public String getEndDestino() {
		return endDestino;
	}

	public void setEndDestino(String endDestino) {
		this.endDestino = endDestino;
	}

	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	public String getEntregue() {
		return entregue;
	}

	public void setEntregue(String entregue) {
		this.entregue = entregue;
	}

	@Override
	public String toString() {
		return "Nf [numero=" + numero + ", cepOrigem=" + cepOrigem + ", endOrigem=" + endOrigem + ", cepDestino="
				+ cepDestino + ", endDestino=" + endDestino + ", distancia=" + distancia + ", entregue=" + entregue
				+ ", roteiro=" + roteiro + "]";
	}

}

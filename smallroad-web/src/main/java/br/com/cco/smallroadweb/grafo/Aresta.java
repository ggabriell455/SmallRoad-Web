package br.com.cco.smallroadweb.grafo;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Aresta {
	private final Vertice v1;

	private final Vertice v2;

	private final BigDecimal w;

	public Aresta(Vertice v1, Vertice v2, BigDecimal w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	public Vertice getV1() {
		return v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public BigDecimal getW() {
		return w;
	}
}

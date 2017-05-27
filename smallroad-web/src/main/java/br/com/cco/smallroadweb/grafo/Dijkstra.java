package br.com.cco.smallroadweb.grafo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	private final List<Aresta> arestas;
	private final List<Vertice> vertices;

	private Set<Vertice> resolvidos;
	private List<Vertice> naoResolvidos;
	private Map<Vertice, Vertice> predecessores;
	private Map<Vertice, BigDecimal> distancias;

	public Dijkstra(List<Aresta> arestas, List<Vertice> vertices) {
		this.arestas = arestas;
		this.vertices = vertices;
	}

	public Vertice extrairMinimo(Vertice origem, List<Vertice> vertices) {
		Vertice minimo = null;
		for (Vertice atual : vertices) {
			if (minimo == null) {
				minimo = atual;
			} else if (getW(origem, atual).compareTo(getW(origem, minimo)) == -1) {
				minimo = atual;
			}
		}
		return minimo;
	}

	public void executar(Vertice source) {
		resolvidos = new HashSet<Vertice>();
		naoResolvidos = new ArrayList<Vertice>();
		predecessores = new HashMap<Vertice, Vertice>();
		distancias = new HashMap<Vertice, BigDecimal>();

		for (Vertice v : this.vertices) {
			distancias.put(v, new BigDecimal("9999999999"));
			predecessores.put(v, null);
		}

		naoResolvidos.addAll(this.vertices);

		Vertice atual = null;
		Vertice anterior = null;
		int size = naoResolvidos.size();
		for (int i = 0; i < size; i++) {
			if (anterior != null) {
				atual = extrairMinimo(anterior, naoResolvidos);
			} else {
				atual = naoResolvidos.get(i);
			}
			resolvidos.add(atual);

			if (anterior != null) {
				distancias.put(atual, getW(anterior, atual));
				predecessores.put(atual, anterior);
			} else {
				distancias.put(atual, new BigDecimal("0"));
			}

			anterior = atual;
			naoResolvidos.remove(atual);
		}

	}

	private BigDecimal getW(Vertice v1, Vertice v2) {
		for (Aresta a : this.arestas) {
			if (a.getV1().equals(v1) && a.getV2().equals(v2) || a.getV1().equals(v2) && a.getV2().equals(v1)) {
				return a.getW();
			}
		}
		return new BigDecimal("0");
	}

	private List<Vertice> getAdjacentes(Vertice v) {
		List<Vertice> adjacentes = new ArrayList<Vertice>();
		for (Aresta a : this.arestas) {
			if (a.getV1().equals(v) && naoResolvidos.contains(a.getV2())) {
				adjacentes.add(a.getV2());
			} else if (a.getV2().equals(v) && naoResolvidos.contains(a.getV1())) {
				adjacentes.add(a.getV1());
			}
		}
		return adjacentes;
	}

	public List<Vertice> getCaminhoBonito(Vertice alvo) {
		List<Vertice> caminho = new ArrayList<Vertice>();
		Vertice atual = alvo;
		caminho.add(atual);
		while (predecessores.get(atual) != null) {
			atual = predecessores.get(atual);
			caminho.add(atual);
		}
		Collections.reverse(caminho);
		return caminho;
	}

	public LinkedList<Vertice> getCaminho(Vertice alvo) {
		LinkedList<Vertice> caminho = new LinkedList<Vertice>();
		Vertice passo = alvo;
		if (predecessores.get(passo) == null) {
			return caminho;
		}
		caminho.add(passo);
		while (predecessores.get(passo) != null) {
			passo = predecessores.get(passo);
			caminho.add(passo);
		}
		Collections.reverse(caminho);
		return caminho;
	}

	private Vertice extrairMinimo(Set<Vertice> vertices) {
		Vertice minimo = null;
		for (Vertice v : vertices) {

			if (minimo == null) {
				minimo = v;
			} else if (distancias.get(v).compareTo(distancias.get(minimo)) == -1) {
				minimo = v;
			}
		}
		return minimo;
	}

}

package br.com.cco.smallroadweb.grafo;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	private Map<Vertice, Vertice> proximos;

	public Dijkstra(List<Aresta> arestas, List<Vertice> vertices) {
		this.arestas = arestas;
		this.vertices = vertices;
	}

	public void executar() {
		resolvidos = new HashSet<Vertice>();
		naoResolvidos = new ArrayList<Vertice>();
		proximos = new HashMap<Vertice, Vertice>();

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
				proximos.put(anterior, atual);
			}
			anterior = atual;
			naoResolvidos.remove(atual);
		}

	}

	public Vertice extrairMinimo(Vertice origem, List<Vertice> vertices) {
		Vertice minimo = null;
		for (Vertice atual : vertices) {
			if (minimo == null) {
				minimo = atual;
			} else if (getDistancia(origem, atual).compareTo(getDistancia(origem, minimo)) == -1) {
				minimo = atual;
			}
		}
		return minimo;
	}

	private BigDecimal getDistancia(Vertice v1, Vertice v2) {
		for (Aresta a : this.arestas) {
			if (a.getV1().equals(v1) && a.getV2().equals(v2) || a.getV1().equals(v2) && a.getV2().equals(v1)) {
				return a.getW();
			}
		}
		return new BigDecimal("0");
	}

	public Map<Vertice, Vertice> getProximos() {
		return proximos;
	}

	public LinkedList<Vertice> getCaminho(Vertice alvo) {
		LinkedList<Vertice> caminho = new LinkedList<Vertice>();
		Vertice passo = alvo;
		if (proximos.get(passo) == null) {
			return caminho;
		}
		caminho.add(passo);
		while (proximos.get(passo) != null) {
			passo = proximos.get(passo);
			caminho.add(passo);
		}
		return caminho;
	}

}

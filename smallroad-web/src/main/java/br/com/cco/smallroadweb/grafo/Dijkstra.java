package br.com.cco.smallroadweb.grafo;



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
	private Set<Vertice> naoResolvidos;
	private Map<Vertice, Vertice> predecessores;
	private Map<Vertice, Integer> distancias;

	public Dijkstra(List<Aresta> arestas, List<Vertice> vertices) {
		this.arestas = arestas;
		this.vertices = vertices;
	}

	public void executar(Vertice source) {
		resolvidos = new HashSet<Vertice>();
		naoResolvidos = new HashSet<Vertice>();
		predecessores = new HashMap<Vertice, Vertice>();
		distancias = new HashMap<Vertice, Integer>();

		for (Vertice v : this.vertices) {
			distancias.put(v, Integer.MAX_VALUE);
			predecessores.put(v, null);
		}

		distancias.put(source, 0);
		naoResolvidos.addAll(this.vertices);

		while (naoResolvidos.size() > 0) {
			Vertice minimo = extrairMinimo(naoResolvidos);
			resolvidos.add(minimo);

			for (Vertice v : getAdjacentes(minimo)) {
				if (distancias.get(v) > distancias.get(minimo) + getW(minimo, v)) {
					distancias.put(v, distancias.get(minimo) + getW(minimo, v));
					predecessores.put(v, minimo);
				}
			}
			naoResolvidos.remove(minimo);
		}
	}

	private int getW(Vertice v1, Vertice v2) {
		for (Aresta a : this.arestas) {
			if (a.getV1().equals(v1) && a.getV2().equals(v2) || a.getV1().equals(v2) && a.getV2().equals(v1)) {
				return a.getW();
			}
		}
		return 0;
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
			} else if (distancias.get(v) < distancias.get(minimo)) {
				minimo = v;
			}
		}
		return minimo;
	}

}

package br.com.cco.smallroadweb.grafo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cco.smallroadweb.entity.Nf;

public class Main {

	private static Map<Integer, Nf> nfs;
	private static List<Vertice> vertices = new ArrayList<Vertice>();
	private static List<Aresta> arestas = new ArrayList<Aresta>();

	public static void main(String[] args) throws IOException {

		Distancia distancia = new Distancia();
		nfs = new HashMap<Integer, Nf>();

		nfs.put(0, new Nf(0, "Faculdade dos Guararapes", "Faculdade dos Guararapes"));
		nfs.put(1, new Nf(1, "Faculdade dos Guararapes", "Rua Severino Jose de Paula, 44"));
		nfs.put(2, new Nf(2, "Faculdade dos Guararapes", "Ulysses Montarroyos, 2330 Piedade"));
		nfs.put(3, new Nf(3, "Faculdade dos Guararapes", "Av. Eng. Domingos Ferreira, 4140"));
		nfs.put(4, new Nf(4, "Faculdade dos Guararapes", "R. Alm. Tamandaré, 170"));
		nfs.put(5, new Nf(5, "Faculdade dos Guararapes", "Rua Jose Braz Moscow, 521"));

		for (Integer key : nfs.keySet()) {
			vertices.add(new Vertice(key));
		}

		for (int i = 0; i < vertices.size(); i++) {
			for (int j = i + 1; j < vertices.size(); j++) {
				BigDecimal distancia2 = distancia.getDistancia(nfs.get(vertices.get(i).getId()).getEndDestino(),
						nfs.get(vertices.get(j).getId()).getEndDestino());
				addAresta(i, j, distancia2);
			}
		}

		Dijkstra dijkstra = new Dijkstra(arestas, vertices);
		dijkstra.executar();

		List<Vertice> caminho = dijkstra.getCaminho(vertices.get(0));
		if (!caminho.isEmpty()) {
			for (Vertice v : caminho) {
				System.out.print(v.getId() + "->");
			}
			System.out.println();
		}
	}

	private static void addAresta(int v1Id, int v2Id, BigDecimal w) {
		System.out.println("Vertice" + vertices.get(v1Id).getId() + "> " + vertices.get(v1Id) + " vertice2> "
				+ vertices.get(v2Id) + " distancia> " + w);
		arestas.add(new Aresta(vertices.get(v1Id), vertices.get(v2Id), w));
	}
}

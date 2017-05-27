package br.com.cco.smallroadweb.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.grafo.Aresta;
import br.com.cco.smallroadweb.grafo.Dijkstra;
import br.com.cco.smallroadweb.grafo.Distancia;
import br.com.cco.smallroadweb.grafo.Vertice;


@Service
public class RotaService {

	private static Map<Integer, Nf> nfs;
	private static List<Vertice> vertices = new ArrayList<Vertice>();
	private static List<Aresta> arestas = new ArrayList<Aresta>();
	
	@Autowired
	NfService nfService;

	public List<Nf> criarRota(List<Nf> notasFicais) throws IOException {

		Distancia distancia = new Distancia();
		nfs = new HashMap<Integer, Nf>();
		
		nfs.put(0, new Nf(0, "Faculdade dos Guararapes", "Faculdade dos Guararapes"));
		for(Nf nf : notasFicais){
			
			nfs.put(nf.getNumero(), nf);
			
		}
		

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
		List<Nf> nfs  = new ArrayList<>();
		List<Vertice> caminho = dijkstra.getCaminho(vertices.get(0));
		String caminhoString = "";
		if (!caminho.isEmpty()) {
			for (Vertice v : caminho) {
				nfs.add(nfService.getNf(v.getId()));
				caminhoString= caminhoString+v.getId() + "-> ";
			}
		}
		System.out.println("NFS ORDENADAS "+caminhoString);
		return nfs;
	}

	private static void addAresta(int v1Id, int v2Id, BigDecimal w) {
		System.out.println("Vertice" + vertices.get(v1Id).getId() + "> " + vertices.get(v1Id) + " vertice2> "
				+ vertices.get(v2Id) + " distancia> " + w);
		arestas.add(new Aresta(vertices.get(v1Id), vertices.get(v2Id), w));
	}
}

package br.com.cco.smallroadweb.grafo;



import java.util.ArrayList;
import java.util.List;
import br.com.cco.smallroadweb.entity.Nf;


public class Main {
	

	private static List<Nf> nfs;
	private static List<Vertice> vertices = new ArrayList<Vertice>();
	private static List<Aresta> arestas = new ArrayList<Aresta>();

	public static void main(String[] args) {
		
		nfs.add(new Nf(0,"Faculdade dos Guararapes","Faculdade dos Guararapes"));
		nfs.add(new Nf(123456,"Faculdade dos Guararapes","Rua Severino Jose de Paula, 44"));
		nfs.add(new Nf(123456,"Faculdade dos Guararapes","Ulysses Montarroyos, 2330 Piedade"));
		nfs.add(new Nf(123456,"Faculdade dos Guararapes","Av. Eng. Domingos Ferreira, 4140"));
		nfs.add(new Nf(123456,"Faculdade dos Guararapes","R. Alm. Tamandaré, 170"));
		nfs.add(new Nf(123456,"Faculdade dos Guararapes","Rua Jose Braz Moscow, 521"));
	
		
	
		
		for (int i = 0; i < nfs.size(); i++) {
			vertices.add(new Vertice(nfs.get(i).getNumero()));
		}
		
		
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = i+1; j < vertices.size(); j++) {
				addAresta( vertices.get(i).getId(), vertices.get(j).getId(), 1);
				
			}
		}
		
		
		
		
		addAresta(0, 1, 8);
		addAresta(0, 2, 12);
		addAresta(1, 2, 1);
		addAresta(1, 3, 3);
		addAresta(2, 4, 7);
		addAresta(2, 4, 4);
		addAresta(3, 4, 5);
		addAresta(3, 5, 21);
		addAresta(4, 5, 15);
		
		Dijkstra dijkstra = new Dijkstra(arestas, vertices);
		dijkstra.executar(vertices.get(0));
		
		for(int i = 0; i < 6; i++) {
			List<Vertice> caminho = dijkstra.getCaminho(vertices.get(i));
			if(!caminho.isEmpty()) {
				for(Vertice v : caminho) {
					System.out.print(v.getId() + "->");
				}
				System.out.println();
			}
		}
	}
	
	private static void addAresta(int v1Id, int v2Id, int w) {
		arestas.add(new Aresta(vertices.get(v1Id), vertices.get(v2Id), w));
	}
}

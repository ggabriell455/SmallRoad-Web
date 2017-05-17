package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Nf;

public interface NfDAO {
	
	public List<Nf> getNfs();

	public void saveNf(Nf nf);

	public Nf getNf(int id);

	public void deleteNf(int id);
	
	public void deleteNfByNumero(int numero);

	List<Nf> procuraNfsByNumero(int numero);

}

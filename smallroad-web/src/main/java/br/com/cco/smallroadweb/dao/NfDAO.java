package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Nf;

public interface NfDAO {
	
	public List<Nf> getNfs();

	public void saveNf(Nf nf);

	public Nf getNf(Integer id);

	public void deleteNf(Integer id);
	
	public void deleteNfByNumero(Integer numero);

	List<Nf> procuraNfsByNumero(Integer numero);

}

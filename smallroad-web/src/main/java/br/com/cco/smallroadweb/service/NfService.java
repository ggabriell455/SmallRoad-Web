package br.com.cco.smallroadweb.service;

import java.util.List;

import br.com.cco.smallroadweb.entity.Nf;

public interface NfService {
	
	public List<Nf> getNfs();

	public void saveNf(Nf nf);

	public Nf getNf(Integer numero);

	public void deleteNf(Integer numero);
	
	public void deleteNfByNumero(Integer numero);

	List<Nf> procuraNfsByNumero(Integer numero);

}

package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;

public interface NfDAO {

	public List<Nf> getNfs();

	public void saveNf(Nf nf);

	public Nf getNf(Integer numero);

	public void deleteNf(Integer numero);

	public void deleteNfByNumero(Integer numero);

	List<Nf> procuraNfsByNumero(Integer numero);

	public List<Nf> listaNotaSemRoteiro();

	public void addRoteiroOnNf(Roteiro roteiro);

	public List<Nf> listaNotasFromRoteiro(Roteiro roteiro);

	

	void setNfsToNull(List<Nf> nfs, Roteiro roteiro);

	

}

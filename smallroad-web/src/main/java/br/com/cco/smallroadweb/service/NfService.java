package br.com.cco.smallroadweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;


public interface NfService {

	public List<Nf> getNfs();

	public void saveNf(Nf nf);

	public Nf getNf(Integer numero);

	public void deleteNf(Integer numero);

	public void deleteNfByNumero(Integer numero);

	public List<Nf> procuraNfsByNumero(Integer numero);

	public List<Nf> listaNotaSemRoteiro();
	
	public List<Nf> listaNotasFromRoteiro(Roteiro roteiro);

	public void addRoteiroOnNf(Roteiro roteiro);

}

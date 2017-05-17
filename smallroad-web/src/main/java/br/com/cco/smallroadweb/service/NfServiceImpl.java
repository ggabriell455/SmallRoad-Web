package br.com.cco.smallroadweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cco.smallroadweb.dao.NfDAO;
import br.com.cco.smallroadweb.entity.Nf;

@Service
public class NfServiceImpl implements NfService {

	@Autowired
	private NfDAO nfDAO;
	
	
	@Override
	@Transactional
	public void saveNf(Nf nf) {
		nfDAO.saveNf(nf);
		
	}


	@Override
	@Transactional
	public List<Nf> getNfs() {
		return nfDAO.getNfs();
	}


	@Override
	@Transactional
	public Nf getNf(Integer numero) {
		return nfDAO.getNf(numero);
	}


	@Override
	@Transactional
	public void deleteNf(Integer numero) {
		nfDAO.deleteNf(numero);
		
	}


	@Override
	@Transactional
	public void deleteNfByNumero(Integer numero) {
		nfDAO.deleteNf(numero);
		
	}


	@Override
	@Transactional
	public List<Nf> procuraNfsByNumero(Integer numero) {
		return nfDAO.procuraNfsByNumero(numero);
	}

}

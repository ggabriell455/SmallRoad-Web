package br.com.cco.smallroadweb.service;

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

}

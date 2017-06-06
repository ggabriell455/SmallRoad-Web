package br.com.cco.smallroadweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cco.smallroadweb.dao.roteiroDAO;
import br.com.cco.smallroadweb.entity.Roteiro;

@Service
public class RoteiroServiceImpl implements RoteiroService {

	@Autowired
	private roteiroDAO roteiroDAO;

	@Transactional
	@Override
	public void cadastrarRoteiro(Roteiro roteiro) {
		roteiroDAO.cadastrarRoteiro(roteiro);

	}

	@Override
	@Transactional
	public List<Roteiro> getRoteiros() {
		return roteiroDAO.getRoteiros();
	}

	@Override
	@Transactional
	public Roteiro getRoteiroByid(Integer id) {
		return roteiroDAO.getRoteiroByid(id);
	}

	@Override
	@Transactional
	public List<Roteiro> getRoteirosNaoFinalizados() {

		return roteiroDAO.getRoteirosNaoFinalizados();
	}

}

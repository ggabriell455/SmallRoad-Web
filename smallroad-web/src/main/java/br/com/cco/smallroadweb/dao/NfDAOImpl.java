package br.com.cco.smallroadweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Nf;

@Repository
public class NfDAOImpl implements NfDAO {

	// injeta a fabrica de seção
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Nf> getNfs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNf(Nf nf) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(nf);
	}

	@Override
	public Nf getNf(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNf(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNfByNumero(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Nf> procuraNfsByNumero(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

}

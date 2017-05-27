package br.com.cco.smallroadweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Roteiro;

@Repository
public class roteiroDAOImpl implements roteiroDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void cadastrarRoteiro(Roteiro roteiro) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(roteiro);

	}

	@Override
	public void deletarRoteiro(Integer ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Roteiro> getRoteiros() {
		Session session = sessionFactory.getCurrentSession();
		Query<Roteiro> consulta = session.createQuery("From Roteiro", Roteiro.class);
		List<Roteiro> roteiros = consulta.getResultList();
		return roteiros;
	}

	@Override
	public void pesquisarRoteiroById(Integer id) {
		// TODO Auto-generated method stub

	}

}

package br.com.cco.smallroadweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.service.NfService;

@Repository
public class roteiroDAOImpl implements roteiroDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private NfService nfService;

	@Override
	public void cadastrarRoteiro(Roteiro roteiro) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(roteiro);

	}

	@Override
	public void deletarRoteiro(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Roteiro roteiro = getRoteiroByid(id);
		List<Nf> nfs = nfService.listaNotasFromRoteiro(roteiro);
		nfService.setNfsToNull(nfs, roteiro);
		
		currentSession.delete("Roteiro", roteiro);


	}

	@Override
	public List<Roteiro> getRoteiros() {
		Session session = sessionFactory.getCurrentSession();
		Query<Roteiro> consulta = session.createQuery("From Roteiro", Roteiro.class);
		List<Roteiro> roteiros = consulta.getResultList();
		return roteiros;
	}

	@Override
	public Roteiro getRoteiroByid(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Roteiro> consulta = currentSession.createQuery("from Roteiro where id = :id", Roteiro.class);
		consulta.setParameter("id", id);
		System.out.println("CONSULTA"+consulta);
		Roteiro roteiro = consulta.getSingleResult();
		return roteiro;
		
	}

	@Override
	public List<Roteiro> getRoteirosNaoFinalizados() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Roteiro> consulta = currentSession.createQuery("from Roteiro where finalizado is null", Roteiro.class);
		List<Roteiro> roteiros = consulta.getResultList();
		return roteiros;

	}

	

}

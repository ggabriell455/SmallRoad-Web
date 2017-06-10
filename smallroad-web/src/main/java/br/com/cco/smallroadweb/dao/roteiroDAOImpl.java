package br.com.cco.smallroadweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.entity.Usuario;
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

	@Override
	public List<Roteiro> getRoteiroByNome(String nomeProcurado) {
		// pega a seção atual do hibernate
				Session currentSession = sessionFactory.getCurrentSession();

				Query consulta = null;

				//
				// so procura pelo nome se nao for nullo ou vazio
				//
				if (nomeProcurado != null && nomeProcurado.trim().length() > 0) {

					// procura pelo nome ... caso insensitive
					consulta = currentSession.createQuery("from Roteiro where lower(nome) like :nome ", Roteiro.class);
					consulta.setParameter("nome", "%" + nomeProcurado.toLowerCase() + "%");

				} else {
					// se o nome for vazio, traga todos os roteiros
					consulta = currentSession.createQuery("from Roteiro", Roteiro.class);
				}

				// executa a consulta e guarda na lista
				List<Roteiro> roteiros = consulta.getResultList();

				// retorna o resultado
				return roteiros;
	}

	

}

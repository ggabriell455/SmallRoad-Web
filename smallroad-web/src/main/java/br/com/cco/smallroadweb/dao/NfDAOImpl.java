package br.com.cco.smallroadweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Usuario;

@Repository
public class NfDAOImpl implements NfDAO {

	// injeta a fabrica de seção
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Nf> getNfs() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Nf> consulta = 
				currentSession.createQuery("from Nf order by numero",
											Nf.class);
		List<Nf> nfs = consulta.getResultList();
		return nfs;
		
	}

	@Override
	public void saveNf(Nf nf) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(nf);
	}

	@Override
	public Nf getNf(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Nf nf = currentSession.get(Nf.class, id);
		return nf;
		
		
	}
	
	public Nf getNfByNumero(Integer numeroProcurado){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Nf> consulta = currentSession.createQuery("from Nf where numero = :numero", Nf.class);
		consulta.setParameter("numero", numeroProcurado);
		Nf nf =  consulta.getSingleResult();
		return nf;
		
		
	}

	@Override
	public void deleteNf(Integer nfId) {
		
				Session currentSession = sessionFactory.getCurrentSession();
				Query consulta = 
						currentSession.createQuery("delete from nf where id=:nfid");
				consulta.setParameter("nfid", nfId);
				
				consulta.executeUpdate();

	}

	@Override
	public void deleteNfByNumero(Integer nfNumero) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query consulta = 
				currentSession.createQuery("delete from nf where id=:nfnumero");
		consulta.setParameter("nfnumero", nfNumero);
		
		consulta.executeUpdate();

	}

	@Override
	public List<Nf> procuraNfsByNumero(Integer numeroProcurado) {
		 // pega a seção atual do hibernate
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query consulta = null;
        
        //
        // so procura pelo nome se nao for nullo ou vazio
        //
        if (numeroProcurado != null) {

            // procura pelo nome ... caso insensitive
        	consulta =currentSession.createQuery("from Nf where numero like :nome ", Nf.class);
            consulta.setParameter("nome", numeroProcurado);

        }
        else {
            // se o nome for vazio, traga todos os usuarios
        	consulta =currentSession.createQuery("from Nfs", Nf.class);            
        }
        
        // executa a consulta e guarda na lista
        List<Nf> nfs = consulta.getResultList();
                
        // retorna o resultado        
        return nfs;
	}

}

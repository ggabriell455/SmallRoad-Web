package br.com.cco.smallroadweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cco.smallroadweb.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	// injeta a fabrica de seção
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Usuario> getUsuarios() {
		
		// pega a seção atual do hibernate
		Session currentSession = sessionFactory.getCurrentSession();
				
		// cria uma consulta e ordena por nome
		Query<Usuario> consulta = 
				currentSession.createQuery("from Usuario order by nome",
											Usuario.class);
		
		// executa a consulta e atribue a uma lista de usuarios
		List<Usuario> usuarios = consulta.getResultList();
				
		// retorna a lista		
		return usuarios;
	}

	@Override
	public void saveUsuario(Usuario usuario) {

		// pega a seção atual do hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// atualiza(caso exista) ou insere o usuario(caso não exista)
		currentSession.saveOrUpdate(usuario);
		
	}

	@Override
	public Usuario getUsuario(Integer id) {

		// pega a seção atual do hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retorna usuario do banco passando a chave primaria
		Usuario usuario = currentSession.get(Usuario.class, id);
		
		return usuario;
	}

	@Override
	public void deleteUsuario(Integer id) {

		// pega a seção atual do hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// deleta o usuario com a chave primaria passada
		Query consulta = 
				currentSession.createQuery("delete from Usuario where id=:usuarioId");
		consulta.setParameter("usuarioId", id);
		
		consulta.executeUpdate();		
	}

	 @Override
	 public List<Usuario> procuraUsuariosByNome(String nomeProcurado) {

	        // pega a seção atual do hibernate
	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query consulta = null;
	        
	        //
	        // so procura pelo nome se nao for nullo ou vazio
	        //
	        if (nomeProcurado != null && nomeProcurado.trim().length() > 0) {

	            // procura pelo nome ... caso insensitive
	        	consulta =currentSession.createQuery("from Usuario where lower(nome) like :nome ", Usuario.class);
	            consulta.setParameter("nome", "%" + nomeProcurado.toLowerCase() + "%");

	        }
	        else {
	            // se o nome for vazio, traga todos os usuarios
	        	consulta =currentSession.createQuery("from Usuario", Usuario.class);            
	        }
	        
	        // executa a consulta e guarda na lista
	        List<Usuario> usuarios = consulta.getResultList();
	                
	        // retorna o resultado        
	        return usuarios;
	        
	    } //Vê ai gil
}
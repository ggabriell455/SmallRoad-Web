package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Usuario;

public interface UsuarioDAO {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario usuario);

	public Usuario getUsuario(int id);

	public void deleteUsuario(int id);

	List<Usuario> procuraUsuariosByNome(String nomeProcurado);
	
	//TEste de Commit
	
}
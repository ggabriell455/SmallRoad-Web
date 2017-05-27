package br.com.cco.smallroadweb.dao;

import java.util.List;

import br.com.cco.smallroadweb.entity.Usuario;

public interface UsuarioDAO {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario usuario);

	public Usuario getUsuario(Integer id);

	public void deleteUsuario(Integer id);

	List<Usuario> procuraUsuariosByNome(String nomeProcurado);

	// TEste de Commit

}
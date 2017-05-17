package br.com.cco.smallroadweb.service;

import java.util.List;

import br.com.cco.smallroadweb.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario usuario);

	public Usuario getUsuario(int id);

	public void deleteUsuario(int id);

	public List<Usuario> procuraUsuariosPorNome(String nome);
	
}
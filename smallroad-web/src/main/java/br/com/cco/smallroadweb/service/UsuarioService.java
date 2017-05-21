package br.com.cco.smallroadweb.service;

import java.util.List;

import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario usuario);

	public Usuario getUsuario(Integer id);

	public void deleteUsuario(Integer id);

	public List<Usuario> procuraUsuariosPorNome(String nome);
	

	
}
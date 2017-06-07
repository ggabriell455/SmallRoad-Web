package br.com.cco.smallroadweb.service;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.cco.smallroadweb.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario usuario);

	public Usuario getUsuario(Integer id);

	public void deleteUsuario(Integer id);

	public List<Usuario> procuraUsuariosPorNome(String nome);

	public Usuario usuarioExiste(Usuario usuario) throws NoResultException;

}
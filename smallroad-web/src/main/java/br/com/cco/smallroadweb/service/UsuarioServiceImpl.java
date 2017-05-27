package br.com.cco.smallroadweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cco.smallroadweb.dao.UsuarioDAO;
import br.com.cco.smallroadweb.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	// Injeção de depencias UsuarioDAO
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		return usuarioDAO.getUsuarios();
	}

	@Override
	@Transactional
	public void saveUsuario(Usuario usuario) {

		usuarioDAO.saveUsuario(usuario);
	}

	@Override
	@Transactional
	public Usuario getUsuario(Integer id) {

		return usuarioDAO.getUsuario(id);
	}

	@Override
	@Transactional
	public void deleteUsuario(Integer id) {

		usuarioDAO.deleteUsuario(id);
	}

	@Override
	@Transactional
	public List<Usuario> procuraUsuariosPorNome(String nome) {

		return usuarioDAO.procuraUsuariosByNome(nome);
	}

}

package br.com.cco.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cco.smallroadweb.controller.UsuarioController;
import br.com.cco.smallroadweb.entity.Usuario;
import br.com.cco.smallroadweb.service.UsuarioService;

public class TestUsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void test() {
	
	}

}

package br.com.cco.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.entity.Usuario;
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RotaService;
import br.com.cco.smallroadweb.service.RoteiroService;
import br.com.cco.smallroadweb.service.UsuarioService;
import junit.framework.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/smallroad-servlet.xml"})
public class JUnitClass {
		
	@Autowired
	NfService nfService;
	
	@Autowired
	RotaService rotaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RoteiroService roteiroService;
	
	//nf
	
	@Test
	public void testGetNfByNumero(){
	boolean condicao=true;
	
	if(nfService.getNf(1) == null){
		condicao = false;
	}
	
	assertEquals(true, condicao);

	}
	
	@Test
	public void testGetNfs(){
		
	
		
		assertNotNull( nfService.getNf(2));
	}
	
	@Test
	public void testUsuarioLogin(){
		Usuario usuario  = new Usuario();
		usuario.setNome("gil");
		usuario.setSenha("gil1234");
		usuario.setEmail("gil@gil.com");
		usuario.setPerfil("ADMIN");
		usuario.setNickname("gil");
		boolean condicao = true;
		
		try {
			usuarioService.usuarioExiste(usuario);
		} catch (Exception e) {
			condicao = false;
		}
		
		assertEquals(true,condicao);
	}

	
	@Test
	public void testDeleteUsuario(){
		boolean condicao =true;
		
		try {
			usuarioService.deleteUsuario(9999);
		} catch (Exception e) {
			condicao = false;
		}
		assertEquals(true, condicao);

	}

	@Test
	public void testSaveNf(){
		Nf nf = new Nf();
		nf.setNumero(1);
		boolean condicao = true;
		try {
			nfService.saveNf(nf);
		} catch (Exception e) {
			condicao = false;
		}
		
		
		assertEquals(true, condicao);
	
		
	}
	
	//usuario
	@Test
	public void TestsaveUsuario(){
	Usuario usuario = new Usuario();
	usuario.setNome("TESTE USUARIO");
	usuario.setNickname("usuario");
	usuario.setSenha("senhateste");
	usuario.setEmail("usuario@teste.com.br");

	boolean condicao = true;
	
	try {
		usuarioService.saveUsuario(usuario);
	} catch (Exception e) {
		condicao = false;
	}
	
	
	
	assertTrue(condicao);
	

	}
	
	
	
	
	//rota
	@Test
	public void testCriaRota(){
		boolean condicao=true;
		
		try {
			
			Roteiro roteiro  = roteiroService.getRoteiroByid(9999);
			rotaService.criarRota(roteiro.getNfs());
		} catch (Exception e) {
			 condicao = false;
		}
		
		
	
		
		assertEquals(true, condicao);
	}
	
	
		
		
		
	
}

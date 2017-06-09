package br.com.cco.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.entity.Usuario;
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RotaService;
import br.com.cco.smallroadweb.service.RoteiroService;
import br.com.cco.smallroadweb.service.UsuarioService;



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
	public void testGetNfByNumero(Integer numero){
		numero = 1;
	Nf nf = nfService.getNf(1);
	

	}
	
	@Test
	public void testGetNfs(){
		
		List<Nf> nfs = nfService.getNfs();
	}
	
	@Test
	public void testDeleteNf(){
		
		nfService.deleteNf(1);
	}
	
	@Test
	public void testSaveNf(){
		Nf nf = new Nf();
		nf.setNumero(1);
		nf.setCepDestino(54000000);
		nf.setEndDestino("Shopping Guararapes");
		nf.setCepOrigem(400000);
		nf.setEndOrigem("Faculdade dos Gurarapes");
		nfService.saveNf(nf);
	}
	
	//usuario
	@Test
	public void TestsaveUsuario(){
	Usuario usuario = new Usuario();
	usuario.setNome("TESTE USUARIO");
	usuario.setNickname("usuario");
	usuario.setSenha("senhateste");
	usuario.setEmail("usuario@teste.com.br");
	usuario.setPerfil("ADMIN");
	
	usuarioService.saveUsuario(usuario);
	

	}
	
	@Test
	public void testGetUsuario(){
		
		List<Usuario> usuario = usuarioService.getUsuarios();
		
		
	}
	
	@Test
	public void getUsuarioById(Integer numero){
		numero = 4;
		usuarioService.getUsuario(numero);
	}
	@Test
	public void testDeleteUsuario(){
		
		usuarioService.deleteUsuario(4);
	}
	
	
	
	//rota
	@Test
	public void testCriaRota() throws IOException{
		
		Roteiro roteiro  = roteiroService.getRoteiroByid(1);
		List<Nf> nfs = nfService.listaNotasFromRoteiro(roteiro);
		rotaService.criarRota(nfs);
	}
	
	//roteiro
	
		public void testCriaRoteiro(){
		
		List <Nf> nfs = nfService.listaNotaSemRoteiro();
		Roteiro roteiro = new Roteiro();
		roteiro.setId(10);
		roteiro.setNome("ROTEIRO_TESTE");
		roteiro.setNfs(nfs);
		
		
	}
		
	
}

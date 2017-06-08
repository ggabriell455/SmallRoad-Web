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
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RotaService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/smallroad-servlet.xml"})
public class JUnitClass {
		
	@Autowired
	NfService nfService;
	
	@Autowired
	RotaService rotaService;
	
	@Test
	public void testGetNfByNumero(){
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
	
	@Test
	public void testCriaRota(){
		List<Nf> nfs = nfService.getNfs();
		try {
			rotaService.criarRota(nfs);
		} catch (IOException e) {
			System.out.println("SEM CONEXAO");
		}
		
	}
}

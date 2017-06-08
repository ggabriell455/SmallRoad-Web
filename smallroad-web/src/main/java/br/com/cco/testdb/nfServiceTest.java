package br.com.cco.testdb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.service.NfService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/smallroad-servlet.xml"})
public class nfServiceTest {
		
	@Autowired
	NfService nfService;
	
	@Test
	public void test(){
	Nf nf = nfService.getNf(1);

	}

}

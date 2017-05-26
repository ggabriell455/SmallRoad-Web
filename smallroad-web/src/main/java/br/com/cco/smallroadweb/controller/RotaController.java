package br.com.cco.smallroadweb.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.grafo.Rota;
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RotaService;

@Controller
@RequestMapping("/rota")
public class RotaController {
	
	
	@Autowired
	RotaService rotaService;
	
	@Autowired
	NfService nfService;
	
	
	@RequestMapping("/list")
	public String rotaList(@ModelAttribute("rota")Rota request) throws IOException{
		
		
		
		
		return "rota-list";
	}

}

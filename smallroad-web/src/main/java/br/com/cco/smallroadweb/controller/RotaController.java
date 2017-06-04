package br.com.cco.smallroadweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RotaService;
import br.com.cco.smallroadweb.service.RoteiroService;

@Controller
@RequestMapping("/rota")
public class RotaController {
	
	@Autowired
	RotaService rotaService;
	
	@Autowired
	RoteiroService roteiroService;
	
	@Autowired
	NfService nfService;

	@RequestMapping("/list")
	public String list(Model modelo) throws IOException {
		
		Integer id = 6;
		Roteiro roteiro = roteiroService.getRoteiroByid(id);
		List<Nf> nfs =  rotaService.criarRota(nfService.listaNotasFromRoteiro(roteiro));
		modelo.addAttribute("nfs", nfs);
		return "rota-list";

	}

}

package br.com.cco.smallroadweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RoteiroService;

@Controller
@RequestMapping("/roteiro")
public class RoteiroController {
	
	@Autowired
	private RoteiroService roteiroService;
	
	@Autowired
	private NfService nfService;
	
	
	@RequestMapping("/list")
	public String listaRoteiro(Model modelo){
		List<Roteiro> roteiros = roteiroService.getRoteiros();
		modelo.addAttribute("roteiros",roteiros);
		return "roteiro";
		
	}
	
	
	
	@PostMapping("/showFormforAdd")
	public String showFormForAdd(Model modelo, Model modelo2) {
		Roteiro roteiro = new Roteiro();
		List<Nf> nfs = nfService.getNfs();
		modelo2.addAttribute("nfs", nfs);
		modelo.addAttribute("roteiro", roteiro);
		
		return "roteiro-form";
	}
	
	@PostMapping("/cadastrar")
	public String showFormForAdd(@ModelAttribute("roteiro")Roteiro roteiro,@ModelAttribute("nf") Nf nf) {
		roteiroService.cadastrarRoteiro(roteiro);
		nfService.saveNf(nf);
		return "redirect:/roteiro/list";
	}
	
	
	

}

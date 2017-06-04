package br.com.cco.smallroadweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Roteiro;
import br.com.cco.smallroadweb.service.NfService;
import br.com.cco.smallroadweb.service.RotaService;
import br.com.cco.smallroadweb.service.RoteiroService;

@Controller
@RequestMapping("/roteiro")
public class RoteiroController {

	@Autowired
	private RoteiroService roteiroService;

	@Autowired
	private NfService nfService;
	
	@Autowired
	private RotaService rotaService;

	@RequestMapping("/list")
	public String listaRoteiro(Model modelo) {
		List<Roteiro> roteiros = roteiroService.getRoteiros();
		modelo.addAttribute("roteiros", roteiros);
		return "roteiro";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model modelo, Model modelo2) {
		Roteiro roteiro = new Roteiro();
		roteiro.setNfs(nfService.listaNotaSemRoteiro());
		modelo.addAttribute("roteiro", roteiro);
		return "roteiro-form";
	}

	@RequestMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("roteiro") Roteiro roteiro) {
		roteiroService.cadastrarRoteiro(roteiro);
		nfService.addRoteiroOnNf(roteiro);
		return "redirect:/roteiro/list";
	}

	@RequestMapping("/entregar")
	public String listarNfs(@RequestParam("nfId")Integer id) {
		Nf nf = nfService.getNf(id);
		
		
		
		return "redirect:/roteiro/showFormForView?roteiroId="+id;
		
	}
	
	@RequestMapping("showFormForView")
	public String showFormForView(@RequestParam("roteiroId")Integer id, Model modelo) throws IOException{
		Roteiro roteiro = roteiroService.getRoteiroByid(id);
		List<Nf> nfs = rotaService.criarRota(nfService.listaNotasFromRoteiro(roteiro));
		roteiro.setNfs(nfs);
		modelo.addAttribute("roteiro", roteiro);
		return "roteiro-form-view";
		
		
	}

	
}

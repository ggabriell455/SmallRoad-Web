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
		List<Roteiro> roteiros = roteiroService.getRoteirosNaoFinalizados();
		modelo.addAttribute("roteiros", roteiros);
		return "roteiro-list";

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
	public String listarNfs(@RequestParam("nfId")Integer nfId,@RequestParam("roteiroId")Integer roteiroId) {
		Nf nf = nfService.getNf(nfId);
		Roteiro roteiro = roteiroService.getRoteiroByid(roteiroId);
		System.out.println("ROTEIRO ID"+roteiro.getId());
		nf.setEntregue("true");
		nfService.saveNf(nf);
		return "redirect:/roteiro/showFormForView?roteiroId="+roteiro.getId();
		
	}
	
	@RequestMapping("/showFormForView")
	public String showFormForView(@RequestParam("roteiroId")Integer id, Model modelo) throws IOException{
		Roteiro roteiro = roteiroService.getRoteiroByid(id);
		List<Nf> nfs = rotaService.criarRota(nfService.listaNotasFromRoteiro(roteiro));
		roteiro.setNfs(nfs);
		modelo.addAttribute("roteiro", roteiro);
		return "roteiro-form-view";
		
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("roteiroId")Integer id) {
		roteiroService.deletarRoteiro(id);

		return "redirect:/roteiro/list";
		
		
	}
	
	@RequestMapping("/finalizar")
	public String FinalizarJornada(@RequestParam("roteiroId")Integer id){
		Roteiro roteiro = roteiroService.getRoteiroByid(id);
		List<Nf> nfs = nfService.listaNotasFromRoteiro(roteiro);
		
		
		for(Nf nf : nfs){
			
			if(nf.getEntregue() == null){
				nfService.setRoteiroToNull(nf);
				System.out.println("NF NUMERO"+nf.getNumero()+"NF ENTREGUE: "+nf.getEntregue());
			}
		}
		
		
		roteiro.setFinalizado("true");
		roteiroService.cadastrarRoteiro(roteiro);
		
		
		
		return "redirect:/roteiro/list";
	}

	
}

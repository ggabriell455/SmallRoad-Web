package br.com.cco.smallroadweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cco.smallroadweb.entity.Nf;import br.com.cco.smallroadweb.service.NfService;

@Controller
@RequestMapping("/nf")
public class NfController {
	@Autowired
	private NfService nfService;

	@GetMapping("/list")
	public String listUsuarios(Model modelo) {

		// pega usuarios do serviço

		List<Nf> nfs = nfService.getNfs();

		// adiciona usuário ao modelo
		modelo.addAttribute("nfs", nfs);
		// retorna p/ view list-usuarios.jsp
		return "list-nf";
	}

	@GetMapping("/delete")
	public String deleteNf(@RequestParam("nfNumero") Integer numero) {

		nfService.deleteNf(numero);

		return "redirect:/nf/list";
	}

	@GetMapping("/showFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("nfNumero") Integer numero, Model model) {

		Nf nf = nfService.getNf(numero);
		model.addAttribute("tempNf", nf);

		return "nf-form";
	}

	@RequestMapping("/saveNf")
	public String saveNf(@ModelAttribute("tempNf") Nf nf) {
		System.out.println("TESTE"+nf.toString());
		nfService.saveNf(nf);
		return "redirect:/nf/list";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model modelo) {

		// cria modelo para ligar ao dado do formulario na view
		Nf nf = new Nf();
		modelo.addAttribute("tempNf", nf);

		return "nf-form";
	}

	@PostMapping("/search")
	public String searchUsuarios(@RequestParam("procuraNumero") Integer numero, Model modelo) {

		// procura usuarios no serviço
		List<Nf> nfs = nfService.procuraNfsByNumero(numero);

		// adiciona usuarios ao modelo
		modelo.addAttribute("nfs", nfs);

		return "list-nf";
	}
	
	@GetMapping("/showFormForView")
	public String showFormForView(@RequestParam("nfNumero") Integer numero, Model modelo) {

		// pega o usuario do serviço
		Nf nf = nfService.getNf(numero);

		// seta usuario como atributo do modelo e pre-popula o formulario
		modelo.addAttribute("nf", nf);

		// envia para o formulario
		return "nf-form-view";
	}
	

}

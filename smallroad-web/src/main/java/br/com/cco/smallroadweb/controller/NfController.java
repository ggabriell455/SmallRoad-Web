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

import br.com.cco.smallroadweb.entity.Nf;
import br.com.cco.smallroadweb.entity.Usuario;
import br.com.cco.smallroadweb.service.NfService;

@Controller
@RequestMapping("/nf")
public class NfController {
	@Autowired
	private NfService nfService;
	
	@GetMapping("/list")
	public String listUsuarios(Model modelo) {
		
		// pega usuarios do servi�o
		
		
		List<Nf> nfs = nfService.getNfs();
				
		// adiciona usu�rio ao modelo
		modelo.addAttribute("nfs", nfs);
		// retorna p/ view list-usuarios.jsp
		return "list-nf";
	}
	
	
	@GetMapping("/delete")
	public String deleteNf(@RequestParam("nfNumero")Integer numero) {
		
		nfService.deleteNf(numero);
		
		return "redirect:/nf/list";
	}
	
	@GetMapping("/ShowFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("nfNumero")Integer numero, Model model) {
		
		Nf nf = nfService.getNf(numero);
		model.addAttribute("tempNf", nf);
		
		return "nf-form";
	}
	
	
	@PostMapping("/saveNf")
	public String saveNf(@ModelAttribute("tempNf") Nf nf){
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
    public String searchUsuarios(@RequestParam("procuraNumero") Integer numero,
                                    Model modelo) {

        // procura usuarios no servi�o
        List<Nf> nfs = nfService.procuraNfsByNumero(numero);
                
        // adiciona usuarios ao modelo
        modelo.addAttribute("nfs", nfs);

        return "list-nf";        
    }
	
	

}

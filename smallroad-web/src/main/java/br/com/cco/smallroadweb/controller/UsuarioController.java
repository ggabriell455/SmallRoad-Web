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

import br.com.cco.smallroadweb.entity.Usuario;
import br.com.cco.smallroadweb.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	// Injetar serviço do usuario
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/list")
	public String listUsuarios(Model modelo) {

		// pega usuarios do serviço
		List<Usuario> usuarios = usuarioService.getUsuarios();

		// adiciona usuário ao modelo
		modelo.addAttribute("usuarios", usuarios);
		// retorna p/ view list-usuarios.jsp
		return "list-usuarios";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model modelo) {

		// cria modelo para ligar ao dado do formulario na view
		Usuario usuario = new Usuario();

		modelo.addAttribute("usuario", usuario);

		return "usuario-form";
	}

	@PostMapping("/saveUsuario")
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {

		// salva o usuario usando o serviço
		usuarioService.saveUsuario(usuario);

		return "redirect:/usuario/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("usuarioId") Integer id, Model modelo) {

		// pega o usuario do serviço
		Usuario usuario = usuarioService.getUsuario(id);

		// seta usuario como atributo do modelo e pre-popula o formulario
		modelo.addAttribute("usuario", usuario);

		// envia para o formulario
		return "usuario-form";
	}

	@GetMapping("/delete")
	public String deleteUsuario(@RequestParam("usuarioId") Integer id) {

		// deleta o usuario (Teste de Gabriel)
		usuarioService.deleteUsuario(id);

		return "redirect:/usuario/list";
	}

	@PostMapping("/search")
	public String searchUsuarios(@RequestParam("data[search]") String nome, Model modelo) {

		// procura usuarios no serviço
		List<Usuario> usuarios = usuarioService.procuraUsuariosPorNome(nome);

		// adiciona usuarios ao modelo
		modelo.addAttribute("usuarios", usuarios);

		return "list-usuarios";
	}
}
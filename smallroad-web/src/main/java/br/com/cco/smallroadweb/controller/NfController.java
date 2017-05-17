package br.com.cco.smallroadweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nf")
public class NfController {
	
	@RequestMapping("/list")
	public String listNfs(){
		return "list-nfs";
	}
	

}

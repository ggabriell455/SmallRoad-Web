package br.com.cco.smallroadweb.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cco.smallroadweb.grafo.Rota;
import br.com.cco.smallroadweb.service.RotaService;

@Controller
@RequestMapping("/rota")
public class RotaController {
	
	
	@Autowired
	RotaService rotaService;
	
	
	@RequestMapping("/list")
	public String rotaList(@ModelAttribute("rota")Rota request) throws IOException{
		
		String origins = "Rua joaquim marques de jesus,176 - Piedade";
		String destinations = "Faculdade dos Guararapes";
		String idioma = "pt-BR";
		String retorno = "xml";
		String mode = "driving";

		String url_request = "https://maps.googleapis.com/maps/api/distancematrix/" + retorno + "?origins=" + origins
				+ "&destinations=" + destinations + "&mode=" + mode + "&language=" + idioma + "&key=" + request.getApiKey1();

		String xml = rotaService.run(url_request);

		/*
		 * String url_request =
		 * "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=pt-BR&key="
		 * + API_KEY;
		 */

		// System.out.println(response);

		String tagValue = rotaService.getTagValue("distance", xml);
		String distanciaText = rotaService.getTagValue("text", tagValue);

		String distanciaString = distanciaText.replaceAll("km", "").replaceAll(",", ".").trim();
		BigDecimal distancia = new BigDecimal(distanciaString);
		request.setDistancia(distancia);
		
		return "rota-list";
	}

}

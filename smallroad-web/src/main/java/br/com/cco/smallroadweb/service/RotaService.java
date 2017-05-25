package br.com.cco.smallroadweb.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface RotaService {
	
	
	public String getTagValue(String tag, String xml);
	
	
	public String run(String url) throws IOException;
	

}

package br.com.cco.smallroadweb.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cco.smallroadweb.dao.RotaDAO;

@Service
public class RotaServiceImpl implements RotaService {
	
	@Autowired
	private RotaDAO rotaDAO;

	@Override
	@Transactional
	public String getTagValue(String tag, String xml) {
		return rotaDAO.getTagValue(tag, xml);
	}

	@Override
	@Transactional
	public String run(String url) throws IOException {
		return rotaDAO.run(url);
		
	}

}

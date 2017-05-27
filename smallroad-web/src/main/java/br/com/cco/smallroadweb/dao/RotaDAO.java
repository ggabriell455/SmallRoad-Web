package br.com.cco.smallroadweb.dao;

import java.io.IOException;

public interface RotaDAO {

	public String getTagValue(String tag, String xml);

	public String run(String url) throws IOException;

}

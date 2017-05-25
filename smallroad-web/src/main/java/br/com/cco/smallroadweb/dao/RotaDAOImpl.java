package br.com.cco.smallroadweb.dao;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import br.com.cco.smallroadweb.grafo.Rota;

@Repository
public class RotaDAOImpl implements RotaDAO {

	public String getTagValue(String tag, String xml) {
		
		String tagStart = "<" + tag + ">";
		int indexStart = xml.indexOf(tagStart) + tagStart.length();
		String tagEnd = "</" + tag + ">";
		int indexEnd = xml.indexOf(tagEnd);
		String result = xml.substring(indexStart, indexEnd);

		return result;
	}

	@Override
	public String run(String url) throws IOException {
		
		Rota rota = new Rota();
		OkHttpClient client = rota.getClient();
		
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

}

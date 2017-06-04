package br.com.cco.smallroadweb.grafo;

import java.io.IOException;
import java.math.BigDecimal;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Distancia {

	String API_KEY = "AIzaSyDQXdKIfpZk8W2l4apTqD1YMb9mWPX5UsE";

	OkHttpClient client = new OkHttpClient();

	private String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public BigDecimal getDistancia(String origem, String destino) throws IOException {

		String origins = origem;
		String destinations = destino;
		String idioma = "pt-BR";
		String retorno = "xml";
		String mode = "driving";

		String url_request = "https://maps.googleapis.com/maps/api/distancematrix/" + retorno + "?origins=" + origins
				+ "&destinations=" + destinations + "&mode=" + mode + "&language=" + idioma + "&key=" + API_KEY;

		String xml = this.run(url_request);

		String tagValue = getTagValue("distance", xml);
		String distanciaText = getTagValue("text", tagValue);

		String distanciaString = distanciaText.replaceAll("km", "").replaceAll(",", ".").trim();

		BigDecimal distancia = new BigDecimal(distanciaString);
		return distancia;
	}

	private String getTagValue(String tag, String xml) {

		String tagStart = "<" + tag + ">";
		int indexStart = xml.indexOf(tagStart) + tagStart.length();
		String tagEnd = "</" + tag + ">";
		int indexEnd = xml.indexOf(tagEnd);
		String result = xml.substring(indexStart, indexEnd);

		return result;

	}

}

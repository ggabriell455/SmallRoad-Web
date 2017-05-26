package br.com.cco.smallroadweb.grafo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.math.BigDecimal;

public class Grafo {

	private static final String API_KEY = "AIzaSyDQXdKIfpZk8W2l4apTqD1YMb9mWPX5UsE";

	OkHttpClient client = new OkHttpClient();

	public String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static String getTagValue(String tag, String xml) {

		String tagStart = "<" + tag + ">";
		int indexStart = xml.indexOf(tagStart) + tagStart.length();
		String tagEnd = "</" + tag + ">";
		int indexEnd = xml.indexOf(tagEnd);
		String result = xml.substring(indexStart, indexEnd);

		return result;

	}

	public static void main(String[] args) throws IOException {

		Grafo request = new Grafo();

		String origins = "Rua Padre Manual da Nobrega,31 Caruaru";
		String destinations = "Comercial Batista LTDA";
		String idioma = "pt-BR";
		String retorno = "xml";
		String mode = "driving";

		String url_request = "https://maps.googleapis.com/maps/api/distancematrix/" + retorno + "?origins=" + origins
				+ "&destinations=" + destinations + "&mode=" + mode + "&language=" + idioma + "&key=" + API_KEY;

		String xml = request.run(url_request);

		/*
		 * String url_request =
		 * "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=pt-BR&key="
		 * + API_KEY;
		 */

		// System.out.println(response);

		String tagValue = getTagValue("distance", xml);
		String distanciaText = getTagValue("text", tagValue);

		String distanciaString = distanciaText.replaceAll("km", "").replaceAll(",", ".").trim();

		System.out.println(distanciaString);
		BigDecimal distancia = new BigDecimal(distanciaString);

	}

}

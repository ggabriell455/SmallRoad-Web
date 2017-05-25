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

	public static void main(String[] args) throws IOException {

		Grafo request = new Grafo();

		String origins = "Rua joaquim marques de jesus,176 - Piedade";
		String destinations = "Bahia";
		String idioma = "pt-BR";
		String retorno = "xml";
		String mode = "driving";

		String url_request = "https://maps.googleapis.com/maps/api/distancematrix/" + retorno + "?origins=" + origins
				+ "&destinations=" + destinations + "&mode=" + mode + "&language=" + idioma + "&key=" + API_KEY;

		// String url_request =
		// "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=pt-BR&key="
		// + API_KEY;

		String response = request.run(url_request);
		String tagValue = getTagValue("distance", response);

		String distanciaText = getTagValue("text", tagValue);

		BigDecimal distancia = new BigDecimal(distanciaText.replaceAll("km", "").trim());

		System.out.println(distancia);

	}

	public static String getTagValue(String tag, String xml) {

		String tagStart = "<" + tag + ">";
		int indexStart = xml.indexOf(tagStart) + tagStart.length();
		String tagEnd = "</" + tag + ">";
		int indexEnd = xml.indexOf(tagEnd);
		String result = xml.substring(indexStart, indexEnd);

		return result;

	}

}

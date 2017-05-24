package br.com.cco.smallroadweb.grafo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

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

		String origins = "Pernambuco";
		String destinations = "Bahia";
		String idioma = "pt-BR";
		String retorno = "json";
		String mode = "driving";

		String url_request = "https://maps.googleapis.com/maps/api/distancematrix/" + retorno + "?origins=" + origins
				+ "&destinations=" + destinations + "&mode=" + mode + "&language=" + idioma + "&key=" + API_KEY;

		// String url_request =
		// "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=pt-BR&key="
		// + API_KEY;

		String response = request.run(url_request);
		System.out.println(response);

	}
}

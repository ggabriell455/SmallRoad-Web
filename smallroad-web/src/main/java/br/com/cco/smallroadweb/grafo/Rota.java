package br.com.cco.smallroadweb.grafo;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.squareup.okhttp.OkHttpClient;


@Entity
public class Rota {
	
	private static final String API_KEY1 = "AIzaSyDQXdKIfpZk8W2l4apTqD1YMb9mWPX5UsE";
	
	private BigDecimal distancia;
	
	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	private  OkHttpClient client = new OkHttpClient();

	public OkHttpClient getClient() {
		return client;
	}

	public void setClient(OkHttpClient client) {
		this.client = client;
	}

	public static String getApiKey1() {
		return API_KEY1;
	}
	
	
	

}

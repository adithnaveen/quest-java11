package com.training.exilant;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPRequest04 {
	public static void main(String[] args) {
		String domain ="http://probits.in";
		var request = HttpRequest.newBuilder()
				.uri(URI.create(domain))
				.build(); 

		var client = HttpClient.newHttpClient(); 

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse :: statusCode)
			.thenAccept(System.out :: println)
			.join(); 
	}
}

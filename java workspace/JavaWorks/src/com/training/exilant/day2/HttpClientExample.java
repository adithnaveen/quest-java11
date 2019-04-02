package com.training.exilant.day2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientExample {
	
	private static String url="https://jsonplaceholder.typicode.com/posts/1"; 
	private static String postPayload="{\r\n" + 
			"  \"userId\":222,\r\n" + 
			"  \"id\": 222,\r\n" + 
			"  \"title\": \"sample\",\r\n" + 
			"  \"body\": \"Sample Body\"\r\n" + 
			"}"; 
	
	public static void main(String[] args) throws 
		IOException, InterruptedException, ExecutionException {
//		httpGetRequest(); 
//		httpPostRequest(); 
		asyncGetRequest(); 
	}

	private static void asyncGetRequest() throws InterruptedException, ExecutionException {

		HttpClient client = HttpClient.newHttpClient(); 
		
		HttpRequest request = HttpRequest.newBuilder().version(Version.HTTP_2)
				.uri(URI.create(url))
				// request header decompresses based on client encoding 
				.headers("Accept-Enconding", "gzip,deflate").build(); 
		
		CompletableFuture<Void> futureResponse = 
				client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.thenAccept(resp -> {
						System.out.println("Response Status " + resp.statusCode());
						System.out.println("Response Body " + resp.body());
					}); 
		
		System.out.println(futureResponse);
		System.out.println(futureResponse.isDone()); 
		
		futureResponse.get(); 
		
	}

	private static void httpPostRequest() throws IOException, InterruptedException {


		HttpClient client = HttpClient.newHttpClient(); 
		
		HttpRequest request = HttpRequest.newBuilder().version(Version.HTTP_2)
				.uri(URI.create(url))
				.POST(BodyPublishers.ofString(postPayload))
				.build(); 
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
		System.out.println(response.statusCode());
		
	}

	private static void httpGetRequest() throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient(); 
		
		HttpRequest request = HttpRequest.newBuilder().version(Version.HTTP_2)
				.uri(URI.create(url))
				// request header decompresses based on client encoding 
				.headers("Accept-Enconding", "gzip,deflate").build(); 
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); 
		
		String responseBody = response.body(); 
		int  statusCode = response.statusCode(); 
		
		System.out.println("HttpRequet response -> " + responseBody);
		System.out.println("Staus Code  -> " + statusCode);
		
		
		
		
		
	}
}











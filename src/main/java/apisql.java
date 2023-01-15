

	import java.io.FileWriter;
	import java.io.IOException;
	import java.net.URI;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;
	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.Scanner;
	import java.util.Set;

	public class apisql {

		public static void main(String[] args) throws IOException, InterruptedException {
	        HttpClient apiClient = HttpClient.newHttpClient();
	        HttpRequest apiRequest = HttpRequest.newBuilder()
	                .uri(URI.create("http://universities.hipolabs.com/search?country=United+States"))
	                .build();// fetching the API
	        HttpResponse<String> fetchAPI = apiClient.send(apiRequest,
	                HttpResponse.BodyHandlers.ofString());
	        System.out.println("The JSON of the API is :" +fetchAPI.body());
		}
	}
	
	
	
	
	


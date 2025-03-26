package com.raj.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class RestClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientExampleApplication.class, args);
		
		
//		RestClient restClient = RestClient.create();
//		
//		 String url = "https://jsonplaceholder.typicode.com/posts/1";
//		 
//		 String response = restClient.get().uri(url).retrieve().body(String.class);
//		 
//		 System.out.println(response);
//		
	}

}

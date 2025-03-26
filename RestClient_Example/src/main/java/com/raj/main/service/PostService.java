package com.raj.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PostService {
	
	private final RestClient restClient;

	public PostService(RestClient restClient) {
		this.restClient = restClient;
	}
	
	
	public String getPostById(Long id) {
		String url = "https://jsonplaceholder.typicode.com/posts/" + id;
		
		return  restClient.get().uri(url).retrieve().body(String.class);
	}
	
	

}

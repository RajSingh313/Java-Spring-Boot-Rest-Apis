package com.raj.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.main.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/{id}")
	public String getPost(@PathVariable Long id) {
		return postService.getPostById(id);
	}
	
	

}

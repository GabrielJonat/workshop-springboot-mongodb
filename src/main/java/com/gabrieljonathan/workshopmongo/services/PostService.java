package com.gabrieljonathan.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrieljonathan.workshopmongo.domain.Post;
import com.gabrieljonathan.workshopmongo.repositories.PostRepository;
import com.gabrieljonathan.workshopmongo.services.exceptions.ObjectNotFounndException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Optional<Post> findById(String id) {
		
		Optional<Post> post = repo.findById(id);
		
		if (post == null)
			throw new ObjectNotFounndException("Object not found");
		else
			return post;
	}
	
}

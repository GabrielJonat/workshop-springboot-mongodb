package com.gabrieljonathan.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gabrieljonathan.workshopmongo.domain.Post;
import com.gabrieljonathan.workshopmongo.repositories.PostRepository;
import com.gabrieljonathan.workshopmongo.resources.util.URL;
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
	
	public List<Post> ultraSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.UltraMegaBlasterPowerSearch(text, minDate, maxDate);
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}

package com.gabrieljonathan.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrieljonathan.workshopmongo.domain.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria  = new User("1", "Maria da Silva", "maria@gmail.com");
		User abner  = new User("1", "Abner Carvalho", "aCarvalho912@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,abner));
		return ResponseEntity.ok().body(list);
	}

}

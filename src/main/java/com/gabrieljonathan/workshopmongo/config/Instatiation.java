package com.gabrieljonathan.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrieljonathan.workshopmongo.domain.Post;
import com.gabrieljonathan.workshopmongo.domain.User;
import com.gabrieljonathan.workshopmongo.repositories.PostRepository;
import com.gabrieljonathan.workshopmongo.repositories.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Post pst1 = new Post(null,sdf.parse("19/11/2018"),"Data Comemorativa", "Esse dia foi o dia mais importante para o desenvolvedor desta aplicação",maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		postRepository.save(pst1);
		
	}

}

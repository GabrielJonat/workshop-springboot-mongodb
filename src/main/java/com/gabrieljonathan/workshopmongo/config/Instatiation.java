package com.gabrieljonathan.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrieljonathan.workshopmongo.domain.Post;
import com.gabrieljonathan.workshopmongo.domain.User;
import com.gabrieljonathan.workshopmongo.dto.AuthorDTO;
import com.gabrieljonathan.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Post pst1 = new Post(null,sdf.parse("19/11/2018"),"Data Comemorativa", "Esse dia foi o dia mais importante para o desenvolvedor desta aplicação", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Já fazem 5 anos!",sdf.parse("03/05/2024"), new AuthorDTO(bob));
		CommentDTO c2 = new CommentDTO("Que boa notícia de grande alegria!",sdf.parse("03/05/2024"), new AuthorDTO(alex));
		
		pst1.getCommnets().addAll(Arrays.asList(c1,c2));
		
		postRepository.save(pst1);
		
		maria.getPosts().add(pst1);
		
		userRepository.save(maria);
		
	}

}

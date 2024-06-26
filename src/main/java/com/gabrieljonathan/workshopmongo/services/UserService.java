package com.gabrieljonathan.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrieljonathan.workshopmongo.domain.User;
import com.gabrieljonathan.workshopmongo.dto.UserDTO;
import com.gabrieljonathan.workshopmongo.repositories.UserRepository;
import com.gabrieljonathan.workshopmongo.services.exceptions.ObjectNotFounndException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		
		return repo.findAll();
	}
	
	public Optional<User> findById(String id) {
		
		Optional<User> user = repo.findById(id);
		
		if (user == null)
			throw new ObjectNotFounndException("Object not found");
		else
			return user;
	}
	
	public User insert(User obj) {
		
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		
		if( repo.findById(id) == null)
			throw new ObjectNotFounndException("Object not found");

		else
			
			repo.deleteById(id);
	}
	
	public Optional<User> update(User obj) {
		
		Optional<User> newObj = repo.findById(obj.getId());
		UpdateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void UpdateData(Optional<User> newObj, User obj) {
		
		newObj.get().setName(obj.getName());
		newObj.get().setEmail(obj.getEmail());
	}
	
	public User fromUserDTO(UserDTO objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
}

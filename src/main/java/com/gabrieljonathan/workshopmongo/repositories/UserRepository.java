package com.gabrieljonathan.workshopmongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrieljonathan.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> save(Optional<User> newObj);

}

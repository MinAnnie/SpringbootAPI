package com.ingeneo.APIRest.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.APIRest.entities.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Transactional(readOnly = true)
	Optional<User> findByUsername(String username);

}

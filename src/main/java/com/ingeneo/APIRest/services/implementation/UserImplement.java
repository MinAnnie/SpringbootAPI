package com.ingeneo.APIRest.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingeneo.APIRest.dto.UserDTO;
import com.ingeneo.APIRest.dto.UserRequest;
import com.ingeneo.APIRest.entities.User;
import com.ingeneo.APIRest.repository.UserRepository;
import com.ingeneo.APIRest.services.interfaces.UserService;
import com.ingeneo.APIRest.utilities.hash.BCrypt;
import com.ingeneo.APIRest.utilities.helpers.Helpers;


@Component
public class UserImplement implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDTO> findAll() {
		
		List<UserDTO> dto = new ArrayList<>();
		
		Iterable<User> users = this.userRepository.findAll();

		for(User user: users) {
			UserDTO userDTO = Helpers.modelMapper().map(user, UserDTO.class);
			
			dto.add(userDTO);
		}
		return dto;
	}

	@Override
	public UserDTO findByUsername(String username) {
		
		Optional<User> users = this.userRepository.findByUsername(username);
		
		if(!users.isPresent()) {
			return null;
		}
		
		return Helpers.modelMapper().map(users.get(), UserDTO.class);
	}

	@Override
	public UserDTO findByUserId(int id) {
		
		Optional<User> users = this.userRepository.findById(id);
		
		if(!users.isPresent()) {
			return null;
		}
		
		return Helpers.modelMapper().map(users.get(), UserDTO.class);
	}

	@Override
	public void save(UserRequest user) {
		
		User users = Helpers.modelMapper().map(user, User.class);
		
		users.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		this.userRepository.save(users);
	}

	@Override
	public void saveAll(List<UserRequest> users) {
		
		List<User> u= new ArrayList<>();
		
		for(UserRequest user: users) {		
			User us = Helpers.modelMapper().map(user, User.class);
			
			u.add(us);
		}
		
		this.userRepository.saveAll(u);
		
	}

	@Override
	public void deleteById(int id) {
		this.userRepository.deleteById(id);
		
	}
	
	private UserDTO convertToUserDTO(final User user) {
		return Helpers.modelMapper().map(user, UserDTO.class);
		
	}

	@Override
	public void update(UserRequest request, int id) {
		Optional<User> users = this.userRepository.findById(id);
		
		User user = users.get();
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setUsername(request.getUsername());
		
		if(request.getPassword().isEmpty()) {
			user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
		}
		
		this.userRepository.save(user);
		
	}
	

}

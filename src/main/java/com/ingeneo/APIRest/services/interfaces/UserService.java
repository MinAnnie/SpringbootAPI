package com.ingeneo.APIRest.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ingeneo.APIRest.dto.UserDTO;
import com.ingeneo.APIRest.dto.UserRequest;

@Service
public interface UserService {

	List<UserDTO> findAll();
	
	UserDTO findByUsername(String username);
	UserDTO findByUserId(int id);
	
	void save(UserRequest user);
	
	void update(UserRequest user, int id);
	
	void saveAll(List<UserRequest> users);
	
	void deleteById(int id);
}

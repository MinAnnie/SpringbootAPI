package com.ingeneo.APIRest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.APIRest.dto.UserRequest;
import com.ingeneo.APIRest.services.interfaces.UserService;
import com.ingeneo.APIRest.utilities.exceptions.ApiUnprocessableEntity;
import com.ingeneo.APIRest.validator.UserValidatorImplement;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class ApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidatorImplement userValidatorImpl;
	
	@GetMapping(value = "/all", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	
	@GetMapping(value = "/by/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
		return ResponseEntity.ok(this.userService.findByUsername(username));
	}
	
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) throws ApiUnprocessableEntity{
		this.userValidatorImpl.validator(request);
		this.userService.save(request);
		
		return ResponseEntity.ok(Boolean.TRUE);
	}

	
	@DeleteMapping(value = "/{id}/delete")
	public ResponseEntity<Object> deteleUser(@PathVariable int id) {
		this.userService.deleteById(id);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	
	@PutMapping(value = "/{id}/update")
	public ResponseEntity<Object> updateUser(@RequestBody UserRequest request, @PathVariable int id){
		this.userService.update(request, id);
		return ResponseEntity.ok(Boolean.TRUE);
	}
}

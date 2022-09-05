package com.ingeneo.APIRest.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequest implements Serializable{
	

	@JsonProperty("FirstName")
	private String firstname;
	@JsonProperty("LastName")
	private String lastname;
	@JsonProperty("UserName")
	private String username;
	@JsonProperty("Password")
	private String password;

}

package com.ingeneo.APIRest.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/** 
 * Excepción personalizada de estatus 422
 * */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception{
	
	public ApiUnprocessableEntity(String message) {
		super(message);
	}
}

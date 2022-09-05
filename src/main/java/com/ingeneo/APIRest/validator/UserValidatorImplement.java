package com.ingeneo.APIRest.validator;

import org.springframework.stereotype.Component;

import com.ingeneo.APIRest.dto.UserRequest;
import com.ingeneo.APIRest.utilities.exceptions.ApiUnprocessableEntity;

@Component
public class UserValidatorImplement implements UserValidator{

	public void validator(UserRequest request) throws ApiUnprocessableEntity {
		//validación nombre vacío
		if(request.getFirstname() ==  null || request.getFirstname().isEmpty()) {
			message("Debes ingresar el nomnbre >:c");
		}
		
		//validación tamaño del nombre
		if(request.getFirstname().length() < 3 ) {
			message("Este nombre es demasiado corto >:c debes tener mínimo 3 carácteres");
		}
		
		
		//validación apellido vacío
		if(request.getLastname() == null || request.getLastname().isEmpty()) {
			message("Debes ingresar el apellido >:c");
		}
		
		//validación tamaño apellido
		if(request.getLastname().length() < 3) {
			message("Este apellido es demasiado corto >:c debes tener mínimo 3 carácteres");
		}
		
		
		//validación nombre de usuario vacío
		if(request.getUsername() == null ||request.getUsername().isEmpty()) {
			message("Debes ingresar el nombre de usuario >:c");
		}
		
		//validación tamaño nombre de usuario
		if(request.getUsername().length() < 3) {
			message("Este nombre de usuario es demasiado corto >:c debes tener mínimo 3 carácteres");
		}
		
		
		//validación contraseña
		if(request.getPassword() == null || request.getPassword().isEmpty()) {
			message("Debes ingresar la contraseña >:c");
		}
		
		//validación tamaño de contraseña
		if(request.getPassword().length() < 6) {
			message("Esta contraseña es demasiado corta >:C debe tener mínimo 6 carácteres");
		}
	}
	
	private void message(String message)  throws ApiUnprocessableEntity{
		throw new ApiUnprocessableEntity(message);
	}
	
}

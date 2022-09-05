package com.ingeneo.APIRest.validator;

import org.springframework.stereotype.Service;

import com.ingeneo.APIRest.dto.UserRequest;
import com.ingeneo.APIRest.utilities.exceptions.ApiUnprocessableEntity;

@Service
public interface UserValidator {
	void validator(UserRequest request) throws  ApiUnprocessableEntity;

}

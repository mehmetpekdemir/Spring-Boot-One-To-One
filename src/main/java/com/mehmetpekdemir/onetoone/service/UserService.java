package com.mehmetpekdemir.onetoone.service;

import com.mehmetpekdemir.onetoone.dto.request.SignUpCreateRequest;
import com.mehmetpekdemir.onetoone.dto.request.LoginRequest;
import com.mehmetpekdemir.onetoone.dto.response.LoginResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserService {

	LoginResponse login(LoginRequest loginRequest);

	void signUp(SignUpCreateRequest signUpCreateRequest);

	boolean existsUserByUsername(String username);

}

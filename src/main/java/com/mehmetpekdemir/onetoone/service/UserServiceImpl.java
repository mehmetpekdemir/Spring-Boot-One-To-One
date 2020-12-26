package com.mehmetpekdemir.onetoone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.onetoone.dto.request.SignUpCreateRequest;
import com.mehmetpekdemir.onetoone.dto.request.LoginRequest;
import com.mehmetpekdemir.onetoone.dto.response.LoginResponse;
import com.mehmetpekdemir.onetoone.entity.UserEntity;
import com.mehmetpekdemir.onetoone.entity.UserInformationEntity;
import com.mehmetpekdemir.onetoone.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	@Transactional
	public LoginResponse login(LoginRequest loginRequest) {
		// Add jwt auth.
		// Look github.com/mehmetpekdemir -> jwt repo
		return null;
	}

	@Override
	@Transactional
	public void signUp(SignUpCreateRequest signUpCreateRequest) {
		UserEntity userEntity = new UserEntity(signUpCreateRequest.getUsername(), signUpCreateRequest.getPassword());

		userEntity.setUserInformationEntity(new UserInformationEntity( //
				signUpCreateRequest.getFirstName(), //
				signUpCreateRequest.getLastName(), //
				signUpCreateRequest.getEmail(), //
				signUpCreateRequest.getBirthDate()));

		userRepository.save(userEntity);
	}

	@Override
	public boolean existsUserByUsername(String username) {
		return userRepository.existsUserByUsername(username);
	}

}

package com.mehmetpekdemir.onetoone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.onetoone.dto.request.CreateSignUpRequest;
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

	// Add jwt auth.
	// Look github.com/mehmetpekdemir -> jwt repo

	@Override
	@Transactional
	public LoginResponse login(LoginRequest loginRequest) {

		return null;
	}

	@Override
	@Transactional
	public void signUp(CreateSignUpRequest createSignUpRequest) {

		UserEntity userEntity = new UserEntity(createSignUpRequest.getUsername(), createSignUpRequest.getPassword());

		userEntity.setUserInformationEntity(new UserInformationEntity( //
				createSignUpRequest.getFirstName(), //
				createSignUpRequest.getLastName(), //
				createSignUpRequest.getEmail(), //
				createSignUpRequest.getBirthDate()));

		userRepository.save(userEntity);
	}

}

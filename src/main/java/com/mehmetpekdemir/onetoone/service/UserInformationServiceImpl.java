package com.mehmetpekdemir.onetoone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.onetoone.common.constant.ExceptionMessages;
import com.mehmetpekdemir.onetoone.dto.request.UserInformationUpdateRequest;
import com.mehmetpekdemir.onetoone.dto.response.UserInformationResponse;
import com.mehmetpekdemir.onetoone.entity.UserEntity;
import com.mehmetpekdemir.onetoone.entity.UserInformationEntity;
import com.mehmetpekdemir.onetoone.exception.CustomException;
import com.mehmetpekdemir.onetoone.repository.UserInformationRepository;
import com.mehmetpekdemir.onetoone.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserInformationServiceImpl implements UserInformationService {

	private final UserInformationRepository userInformationRepository;
	private final UserRepository userRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserInformationResponse> getUserInformations() {
		return userInformationRepository.findAll().stream() //
				.map(userInformation -> mapToUserInformationResponse(userInformation)) //
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserInformationResponse getUserInformationByUserName(String username) {
		final UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST));

		final UserInformationEntity userInformation = userInformationRepository.findById(user.getId()).orElseThrow(
				() -> new CustomException(ExceptionMessages.USER_INFORMATION_NOT_FOUND, HttpStatus.BAD_REQUEST));

		return mapToUserInformationResponse(userInformation);
	}

	@Override
	@Transactional
	public void updateUserInformation(UserInformationUpdateRequest userInformationUpdateRequest) {
		final UserEntity user = userRepository.findByUsername(userInformationUpdateRequest.getUsername())
				.orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST));

		final UserInformationEntity userInformation = userInformationRepository.findById(user.getId()).orElseThrow(
				() -> new CustomException(ExceptionMessages.USER_INFORMATION_NOT_FOUND, HttpStatus.BAD_REQUEST));

		user.setUsername(userInformationUpdateRequest.getUsername());
		user.setPassword(userInformationUpdateRequest.getPassword());
		userInformation.setFirstName(userInformationUpdateRequest.getFirstName());
		userInformation.setLastName(userInformationUpdateRequest.getLastName());
		userInformation.setEmail(userInformationUpdateRequest.getEmail());

		final UserInformationEntity updatedUserInformation = userInformationRepository.save(userInformation);
		user.setUserInformationEntity(updatedUserInformation);

		userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteUserInformation(String username) {
		final UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.BAD_REQUEST));

		userInformationRepository.deleteById(user.getId());
	}

	private UserInformationResponse mapToUserInformationResponse(UserInformationEntity userInformation) {
		return UserInformationResponse.builder()//
				.firstName(userInformation.getFirstName())//
				.lastName(userInformation.getLastName())//
				.email(userInformation.getEmail())//
				.birthDate(userInformation.getBirthDate())//
				.build();//
	}

}

package com.mehmetpekdemir.onetoone.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehmetpekdemir.onetoone.common.annotation.ApiController;
import com.mehmetpekdemir.onetoone.dto.request.CreateUserInformationRequest;
import com.mehmetpekdemir.onetoone.dto.request.UpdateUserInformationRequest;
import com.mehmetpekdemir.onetoone.service.UserInformationService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class UserInformationController {

	private final UserInformationService userInformationService;

	@GetMapping("v1/user-informations")
	public ResponseEntity<?> getUserInformations() {

		final var response = userInformationService.getUserInformations();
		return ResponseEntity.ok(response);
	}

	@GetMapping("v1/user-information")
	public ResponseEntity<?> getUserInformationByUserName(@RequestParam(value = "username") String username) {

		final var response = userInformationService.getUserInformationByUserName(username);
		return ResponseEntity.ok(response);
	}

	@PostMapping("v1/user-information")
	public ResponseEntity<?> createUserInformation(
			@Valid @RequestBody CreateUserInformationRequest createUserInformationRequest) {

		final var response = userInformationService.createUserInformation(createUserInformationRequest);
		return ResponseEntity.ok(response);
	}

	@PutMapping("v1/user-information")
	public ResponseEntity<?> updateUserInformation(
			@Valid @RequestBody UpdateUserInformationRequest updateUserInformationRequest) {

		final var response = userInformationService.updateUserInformation(updateUserInformationRequest);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("v1/user-information")
	public ResponseEntity<?> deleteUserInformation(@RequestParam(value = "username") String username) {

		final var response = userInformationService.deleteUserInformation(username);
		return ResponseEntity.ok(response);
	}

}

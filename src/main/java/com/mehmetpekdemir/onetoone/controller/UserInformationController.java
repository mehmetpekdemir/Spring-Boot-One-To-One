package com.mehmetpekdemir.onetoone.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehmetpekdemir.onetoone.common.GenericResponse;
import com.mehmetpekdemir.onetoone.common.annotation.SecureApiController;
import com.mehmetpekdemir.onetoone.common.constant.GenericMessages;
import com.mehmetpekdemir.onetoone.common.constant.SwaggerMessages;
import com.mehmetpekdemir.onetoone.dto.request.UpdateUserInformationRequest;
import com.mehmetpekdemir.onetoone.service.UserInformationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SecureApiController
@RequiredArgsConstructor
public class UserInformationController {

	private final UserInformationService userInformationService;

	@ApiOperation(value = "Get User Informations")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_COMPLETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@GetMapping("v1/user-informations")
	public ResponseEntity<?> getUserInformations() {

		final var response = userInformationService.getUserInformations();
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Get User Information By UserName")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_COMPLETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@GetMapping("v1/user-information")
	public ResponseEntity<?> getUserInformationByUserName( //
			@ApiParam(value = "username", required = true) //
			@RequestParam(value = "username") String username) {

		final var response = userInformationService.getUserInformationByUserName(username);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Update User Information")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_UPDATED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@PutMapping("v1/user-information")
	public ResponseEntity<?> updateUserInformation( //
			@ApiParam(value = "Update User Information Request", required = true) //
			@Valid @RequestBody UpdateUserInformationRequest updateUserInformationRequest) {

		userInformationService.updateUserInformation(updateUserInformationRequest);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_UPDATED));
	}

	@ApiOperation(value = "Delete User Information")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_DELETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@DeleteMapping("v1/user-information")
	public ResponseEntity<?> deleteUserInformation( //
			@ApiParam(value = "username", required = true) //
			@RequestParam(value = "username") String username) {

		userInformationService.deleteUserInformation(username);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
	}

}

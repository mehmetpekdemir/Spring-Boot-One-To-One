package com.mehmetpekdemir.onetoone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mehmetpekdemir.onetoone.common.GenericResponse;
import com.mehmetpekdemir.onetoone.common.annotation.ApiController;
import com.mehmetpekdemir.onetoone.common.constant.GenericMessages;
import com.mehmetpekdemir.onetoone.common.constant.SwaggerMessages;
import com.mehmetpekdemir.onetoone.dto.request.CreateSignUpRequest;
import com.mehmetpekdemir.onetoone.dto.request.LoginRequest;
import com.mehmetpekdemir.onetoone.service.UserService;

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
@ApiController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@ApiOperation(value = "Login")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_LOGIN), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN), //
			@ApiResponse(code = 422, message = SwaggerMessages.UNSUCCESSFUL_LOGIN) //
	})
	@PostMapping("login")
	public ResponseEntity<?> login( //
			@ApiParam(value = "Login Request", required = true) //
			@RequestBody LoginRequest loginRequest) {

		final var response = userService.login(loginRequest);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Sign-up")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_CREATED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@PostMapping("sign-up")
	public ResponseEntity<?> signUp( //
			@ApiParam(value = "Create Sign-up Request", required = true) //
			@RequestBody CreateSignUpRequest createSignUpRequest) {

		userService.signUp(createSignUpRequest);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
	}
}

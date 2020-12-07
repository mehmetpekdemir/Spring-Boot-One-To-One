package com.mehmetpekdemir.onetoone.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mehmetpekdemir.onetoone.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor
public final class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	private final UserService userService;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return !userService.existsUserByUsername(username);
	}
}

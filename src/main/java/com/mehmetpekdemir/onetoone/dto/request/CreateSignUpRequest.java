package com.mehmetpekdemir.onetoone.dto.request;

import java.time.LocalDate;

import com.mehmetpekdemir.onetoone.common.validator.FieldMatch;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword", message = "{one-to-one.constraint.password.FieldMatch.message}")
@ApiModel(value = "Create Sign-Up Request")
public final class CreateSignUpRequest {

	@ApiModelProperty(value = "Username", required = true)
	private String username;

	@ApiModelProperty(value = "Password", required = true)
	private String password;

	@ApiModelProperty(value = "Confirm Password", required = true)
	private String confirmPassword;

	@ApiModelProperty(value = "First Name", required = true)
	private String firstName;

	@ApiModelProperty(value = "Last Name", required = true)
	private String lastName;

	@ApiModelProperty(value = "E-mail", required = true)
	private String email;

	@ApiModelProperty(value = "Birth Date")
	private LocalDate birthDate;

}

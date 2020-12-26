package com.mehmetpekdemir.onetoone.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.mehmetpekdemir.onetoone.common.validator.FieldMatch;
import com.mehmetpekdemir.onetoone.common.validator.UniqueUsername;

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
@ApiModel(value = "Sign-Up Create Request")
public final class SignUpCreateRequest {

	@NotNull
	@UniqueUsername
	@ApiModelProperty(value = "Username", required = true)
	private String username;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{one-to-one.constraint.confirmpassword.Pattern.message}")
	@ApiModelProperty(value = "Password", required = true)
	private String password;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{one-to-one.constraint.confirmpassword.Pattern.message}")
	@ApiModelProperty(value = "Confirm Password", required = true)
	private String confirmPassword;

	@NotNull
	@ApiModelProperty(value = "First Name", required = true)
	private String firstName;

	@NotNull
	@ApiModelProperty(value = "Last Name", required = true)
	private String lastName;

	@NotNull
	@ApiModelProperty(value = "E-mail", required = true)
	private String email;

	@ApiModelProperty(value = "Birth Date")
	private LocalDate birthDate;

}

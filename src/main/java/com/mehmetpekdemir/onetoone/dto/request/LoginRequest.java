package com.mehmetpekdemir.onetoone.dto.request;

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
@ApiModel(value = "Login Request")
public final class LoginRequest {

	@ApiModelProperty(value = "Username", required = true)
	private String username;

	@ApiModelProperty(value = "Password", required = true)
	private String password;

}

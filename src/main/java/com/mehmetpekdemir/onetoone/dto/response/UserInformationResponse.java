package com.mehmetpekdemir.onetoone.dto.response;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@ApiModel(value = "User Information Response")
public final class UserInformationResponse {

	@ApiModelProperty(value = "First Name")
	private String firstName;

	@ApiModelProperty(value = "Last Name")
	private String lastName;

	@ApiModelProperty(value = "E-mail")
	private String email;

	@ApiModelProperty(value = "Birth Date")
	private LocalDate birthDate;

}

package com.mehmetpekdemir.onetoone.common;

import java.time.LocalDate;

import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
public final class GenericResponse {

	private String message;

	private LocalDate date;

	public GenericResponse(String message) {
		this.message = message;
		date = LocalDate.now();
	}

}
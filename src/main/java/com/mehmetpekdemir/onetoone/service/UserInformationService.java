package com.mehmetpekdemir.onetoone.service;

import java.util.List;

import com.mehmetpekdemir.onetoone.dto.request.UpdateUserInformationRequest;
import com.mehmetpekdemir.onetoone.dto.response.UserInformationResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserInformationService {

	List<UserInformationResponse> getUserInformations();

	UserInformationResponse getUserInformationByUserName(String username);

	void updateUserInformation(UpdateUserInformationRequest updateUserInformationRequest);

	void deleteUserInformation(String username);

}

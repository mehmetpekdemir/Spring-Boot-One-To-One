package com.mehmetpekdemir.onetoone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmetpekdemir.onetoone.dto.request.CreateUserInformationRequest;
import com.mehmetpekdemir.onetoone.dto.request.UpdateUserInformationRequest;
import com.mehmetpekdemir.onetoone.dto.response.UserInformationResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
public class UserInformationServiceImpl implements UserInformationService {

	@Override
	public List<UserInformationResponse> getUserInformations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformationResponse getUserInformationByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformationResponse createUserInformation(CreateUserInformationRequest createUserInformationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformationResponse updateUserInformation(UpdateUserInformationRequest updateUserInformationRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformationResponse deleteUserInformation(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

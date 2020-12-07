package com.mehmetpekdemir.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.onetoone.entity.UserInformationEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface UserInformationRepository extends JpaRepository<UserInformationEntity, Long> {

}

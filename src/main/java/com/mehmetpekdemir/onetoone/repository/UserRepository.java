package com.mehmetpekdemir.onetoone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.onetoone.entity.UserEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

	boolean existsUserByUsername(String username);

}

package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.products.library.model.UserEntity;

public interface UserDao  extends JpaRepository<UserEntity, Long>
{

	UserEntity findUserByEmailAddress(String emailAddress);

	UserEntity findUserByResetKey(String resetKey);

	UserEntity findUserByUsernameAndPassword(String username, String password);

	UserEntity findUserEntityByUsername(String username);
  
}

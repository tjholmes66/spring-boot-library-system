package com.tomholmes.products.library.service;

import java.util.List;

import com.tomholmes.products.library.dto.LoginResponseDTO;
import com.tomholmes.products.library.dto.LoginUserDTO;
import com.tomholmes.products.library.dto.RegisterUserDTO;
import com.tomholmes.products.library.model.UserEntity;

public interface UserService
{
    // CREATE
    UserEntity create(UserEntity userEntity);

    boolean register(RegisterUserDTO registerUserDTO);

    // RETRIEVE
    UserEntity getById(long userId);

    UserEntity getUserEntityByUsername(String username);

    List<UserEntity> getAllUserEntityList();

    UserEntity getUserByUsernameAndPassword(String username, String password);

    UserEntity getUserByResetKey(String resetKey);

    UserEntity getUserByEmailAddress(String emailAddress);

    LoginResponseDTO login(LoginUserDTO loginUserDto);

    // UPDATE
    UserEntity update(UserEntity userEntity);

}

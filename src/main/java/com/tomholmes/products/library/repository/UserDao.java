package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.products.library.model.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long>
{
    @Query(value = "from UserEntity u where (u.emailAddress = :emailAddress)")
    UserEntity findUserByEmailAddress(String emailAddress);

    @Query(value = "from UserEntity u where (u.resetKey = :resetKey)")
    UserEntity findUserByResetKey(String resetKey);

    @Query(value = "from UserEntity u where (u.username = :username) AND (u.password = :password)")
    UserEntity findUserByUsernameAndPassword(String username, String password);

    @Query(value = "from UserEntity u where (u.username = :username)")
    UserEntity findUserEntityByUsername(String username);
}

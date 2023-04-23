package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.products.library.model.TokenEntity;

public interface TokenDao extends JpaRepository<TokenEntity, Long>
{
    @Query(value = "from TokenEntity t where (t.token = :token) and (t.user.enabled = true)")
    TokenEntity findTokenEntityByToken(String token);

    @Query(value = "from TokenEntity t where (t.user.username = :username) order by t.created DESC")
    TokenEntity findTokenEntityByUsername(String username);

    @Query(value = "from TokenEntity t where (t.user.userId = :userId) order by t.created DESC")
    TokenEntity findTokenEntityByUserId(long userId);
}

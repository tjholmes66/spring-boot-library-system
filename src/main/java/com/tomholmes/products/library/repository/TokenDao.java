package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.products.library.model.TokenEntity;

public interface TokenDao extends JpaRepository<TokenEntity, Long>
{
	TokenEntity findTokenEntityByToken(String token);

	TokenEntity findTokenEntityByUserId(long userId);

	TokenEntity findTokenEntityByUsername(String username);
}

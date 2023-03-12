package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.products.library.model.UserRoleEntity;

public interface UserRoleDao  extends JpaRepository<UserRoleEntity, Long>
{

}

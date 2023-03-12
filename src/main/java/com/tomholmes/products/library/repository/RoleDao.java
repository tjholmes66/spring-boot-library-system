package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.products.library.model.RoleEntity;

public interface RoleDao extends JpaRepository<RoleEntity, Long>
{

	RoleEntity findRoleEntityByCode(String roleCode);
  
}

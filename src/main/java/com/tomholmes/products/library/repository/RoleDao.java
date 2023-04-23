package com.tomholmes.products.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.products.library.model.RoleEntity;

public interface RoleDao extends JpaRepository<RoleEntity, Long>
{
    @Query(value = "from RoleEntity role where (role.roleCode = :roleCode)")
    RoleEntity findRoleByCode(String roleCode);
}

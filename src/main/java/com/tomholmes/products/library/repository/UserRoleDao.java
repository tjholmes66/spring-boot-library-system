package com.tomholmes.products.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.products.library.model.RoleEntity;
import com.tomholmes.products.library.model.UserRoleEntity;

public interface UserRoleDao extends JpaRepository<UserRoleEntity, Long>
{
    @Query(value = "select ur.role from UserRoleEntity ur where (ur.user.username = :username)")
    List<RoleEntity> findUserRoleEntityByUsername(String username);

    @Query(value = "select ur.role from UserRoleEntity ur where (ur.user.userId = :userId)")
    List<RoleEntity> findUserRoleEntityByUserId(long userId);
}

package com.tomholmes.products.library.service;

import java.util.List;

import com.tomholmes.products.library.model.RoleEntity;

public interface RoleService
{
    // CREATE
    RoleEntity create(RoleEntity roleEntity);

    // RETRIEVE
    RoleEntity getById(long roleId);

    RoleEntity getRoleEntityByCode(String roleCode);

    List<RoleEntity> getAllRoleEntityList();

    // UPDATE
    RoleEntity update(RoleEntity roleEntity);

    // DELETE
    Boolean deleteById(long roleId);

    Boolean deleteById(RoleEntity roleEntity);
}

package com.tomholmes.products.library.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.products.library.model.RoleEntity;
import com.tomholmes.products.library.repository.RoleDao;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService
{
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao)
    {
        this.roleDao = roleDao;
    }

    @Override
    public RoleEntity create(RoleEntity roleEntity)
    {
        LocalDateTime now = LocalDateTime.now();
        roleEntity.setEnteredBy(1L);
        roleEntity.setEnteredDate(now);
        roleEntity.setEditedBy(1L);
        roleEntity.setEditedDate(now);

        RoleEntity role = roleDao.save(roleEntity);
        return role;
    }

    @Override
    public RoleEntity update(RoleEntity roleEntity)
    {
        RoleEntity oldEntity = roleDao.findById(roleEntity.getRoleId()).orElse(null);
        roleEntity.setEnteredBy(oldEntity.getEnteredBy());
        roleEntity.setEnteredDate(oldEntity.getEnteredDate());

        LocalDateTime now = LocalDateTime.now();
        roleEntity.setEditedBy(1L);
        roleEntity.setEditedDate(now);

        RoleEntity role = roleDao.save(roleEntity);
        return role;
    }

    @Override
    public RoleEntity getById(long roleId)
    {
        RoleEntity role = roleDao.findById(roleId).orElse(null);
        return role;
    }

    @Override
    public List<RoleEntity> getAllRoleEntityList()
    {
        List<RoleEntity> list = roleDao.findAll();
        return list;
    }

    @Override
    public RoleEntity getRoleEntityByCode(String roleCode)
    {
        RoleEntity role = roleDao.findRoleByCode(roleCode);
        return role;
    }

    @Override
    public Boolean deleteById(long roleId)
    {
        Boolean deleteResult = false;
        roleDao.deleteById(roleId);
        return true;
    }

    @Override
    public Boolean deleteById(RoleEntity roleEntity)
    {
        Boolean deleteResult = false;
        roleDao.delete(roleEntity);
        return true;
    }

}

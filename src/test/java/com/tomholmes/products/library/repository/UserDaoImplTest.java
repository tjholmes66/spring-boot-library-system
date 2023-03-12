package com.tomholmes.products.library.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.products.library.model.UserEntity;

public class UserDaoImplTest extends BaseDaoTest
{
    @Autowired
    private UserDao userDao;

    private long _userId = 0;
    private String _username = "test";
    private String _password = "7lQc2WBN2qYrBYwg9ZW7WIoHfD6b1kLTRrQBEzqE3qY=$2j15h6Hwq78amEU5aubuCvVD/2p3Xr3RfaASHW6ULyk=";
    private String _emailAddress = "tom@tomholmes.xyz";
    private boolean _userActive = true;
    private String _userFirstName = "test_FN";
    private String _userLastName = "test_LN";
    private long _editedBy = 1;
    private long _enteredBy = 1;
    private LocalDateTime _editedDate = LocalDateTime.now();
    private LocalDateTime _enteredDate = LocalDateTime.now();
    private long _roleId = 2; // user

    private UserEntity save()
    {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(_userId);

        userEntity.setUsername(_username);
        userEntity.setPassword(_password);

        userEntity.setEnabled(_userActive);
        userEntity.setEmailAddress(_emailAddress);

        userEntity.setFirstName(_userFirstName);
        userEntity.setLastName(_userLastName);

        // =====================================================
        // =====================================================

        userEntity.setEditedBy(_editedBy);
        userEntity.setEditedDate(_editedDate);
        userEntity.setEnteredBy(_enteredBy);
        userEntity.setEnteredDate(_enteredDate);

        return userEntity;
    }

    // UserEntity save(UserEntity userEntity);
    @Test
    public void testUsersave()
    {
        System.out.println("testUsersave: START");

        UserEntity userEntity = save();

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        System.out.println("testUsersave: FINISH");
    }

    // UserEntity updateUserEntity(UserEntity userEntity);
    @Test
    public void testUserUpdate()
    {
        System.out.println("testUserUpdate: START");

        UserEntity userEntity = save();

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        String username = "updated";
        String password = "new_password";
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(username, userEntity.getUsername());
        assertEquals(password, userEntity.getPassword());

        System.out.println("testUserUpdate: FINISH");
    }

    // void deleteUserEntity(long userId);
    // void deleteUserEntity(UserEntity userEntity);

    // UserEntity getUserEntity(long userId);
    @Test
    public void testGetUserEntityById()
    {
        System.out.println("testGetUserEntity: START");

        UserEntity userEntity = save();

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        long userId = userEntity.getUserId();
        userEntity = userDao.findById(userId).orElse(null);

        assertNotNull(userEntity);
        assertEquals(userId, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        System.out.println("testGetUserEntity: FINISH");
    }

    // UserEntity getUserEntityByUsername(String username);
    @Test
    public void testGetUserEntityByUsername()
    {
        System.out.println("testGetUserEntityByUsername: START");

        UserEntity userEntity = save();

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        String username = userEntity.getUsername();
        userEntity = userDao.findUserEntityByUsername(username);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        System.out.println("testGetUserEntityByUsername: FINISH");
    }

    // List<UserEntity> getAllUserEntityList();
    @Test
    public void testGetAllUserEntityList()
    {
        System.out.println("testGetAllUserEntityList: START");

        List<UserEntity> userList = userDao.findAll();

        assertNotNull(userList);
        assertEquals(true, userList.size() > 0);

        System.out.println("testGetAllUserEntityList: FINISH");
    }

    // UserEntity getUserByUsernameAndPassword(String username, String password);
    @Test
    public void testGetUserEntityByUsernameAndPassword()
    {
        System.out.println("testGetUserEntityByUsernameAndPassword: START");

        UserEntity userEntity = save();

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());

        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        userEntity = userDao.findUserByUsernameAndPassword(username, password);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(username, userEntity.getUsername());
        assertEquals(password, userEntity.getPassword());

        System.out.println("testGetUserEntityByUsernameAndPassword: FINISH");
    }

    @Test
    public void testGetUserEntityByResetKey()
    {
        System.out.println("testGetUserEntityByResetKey: START");

        UserEntity userEntity = save();

        String resetKey = "ABCDEF-123456-ABCDEFG-7890";
        userEntity.setResetKey(resetKey);

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(resetKey, userEntity.getResetKey());

        resetKey = userEntity.getResetKey();
        userEntity = userDao.findUserByResetKey(resetKey);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(resetKey, userEntity.getResetKey());

        System.out.println("testGetUserEntityByResetKey: FINISH");
    }

    @Test
    public void testGetUserEntityByEmailAddress()
    {
        System.out.println("testGetUserEntityByEmailAddress: START");

        UserEntity userEntity = save();

        userEntity = userDao.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(_emailAddress, userEntity.getEmailAddress());

        String emailAddress = userEntity.getEmailAddress();
        userEntity = userDao.findUserByEmailAddress(emailAddress);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getUserId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_password, userEntity.getPassword());
        assertEquals(emailAddress, userEntity.getEmailAddress());

        System.out.println("testGetUserEntityByEmailAddress: FINISH");
    }

}

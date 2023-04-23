package com.tomholmes.products.library.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.tomholmes.products.library.dto.BookDTO;
import com.tomholmes.products.library.dto.LoginResponseDTO;
import com.tomholmes.products.library.dto.LoginUserDTO;
import com.tomholmes.products.library.dto.RegisterUserDTO;
import com.tomholmes.products.library.model.BookEntity;
import com.tomholmes.products.library.model.TokenEntity;
import com.tomholmes.products.library.model.UserEntity;
import com.tomholmes.products.library.repository.BookDao;
import com.tomholmes.products.library.repository.TokenDao;
import com.tomholmes.products.library.repository.UserDao;
import com.tomholmes.products.library.util.ShortUUID;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final int CHECKOUT_TIME = 14;

    private UserDao userDao;
    private BookDao bookDao;
    private TokenDao tokenDao;

    public UserServiceImpl(UserDao userDao, BookDao bookDao, TokenDao tokenDao)
    {
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.tokenDao = tokenDao;
    }

    @Override
    public UserEntity create(UserEntity userEntity)
    {
        UserEntity user = userDao.save(userEntity);
        return user;
    }

    @Override
    public UserEntity getById(long userId)
    {
        UserEntity user = userDao.findById(userId).orElse(null);
        return user;
    }

    @Override
    public UserEntity getUserEntityByUsername(String username)
    {
        UserEntity user = userDao.findUserEntityByUsername(username);
        return user;
    }

    @Override
    public List<UserEntity> getAllUserEntityList()
    {
        List<UserEntity> userList = userDao.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserByUsernameAndPassword(String username, String password)
    {
        UserEntity user = userDao.findUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public UserEntity getUserByResetKey(String resetKey)
    {
        UserEntity user = userDao.findUserByResetKey(resetKey);
        return user;
    }

    @Override
    public UserEntity getUserByEmailAddress(String emailAddress)
    {
        UserEntity user = userDao.findUserByEmailAddress(emailAddress);
        return user;
    }

    @Override
    public UserEntity update(UserEntity userEntity)
    {
        UserEntity user = userDao.save(userEntity);
        return user;
    }

    @Override
    public boolean register(RegisterUserDTO registerUserDto)
    {
        boolean response = false;

        String firstName = registerUserDto.getFirstName();
        String lastName = registerUserDto.getLastName();
        String email = registerUserDto.getEmail();

        if (!ObjectUtils.isEmpty(firstName) && !ObjectUtils.isEmpty(lastName) && !ObjectUtils.isEmpty(email))
        {

            UserEntity userEntity = new UserEntity();

            userEntity.setUsername(firstName + lastName);

            // get properties from RegisterUserDTO
            userEntity.setFirstName(firstName);
            userEntity.setLastName(lastName);
            userEntity.setEmailAddress(email);
            userEntity.setCellPhone(registerUserDto.getPhone()); // optional
            userEntity.setDob(registerUserDto.getDob()); // optional

            // Set System properties
            LocalDateTime today = LocalDateTime.now();
            userEntity.setEditedBy(1);
            userEntity.setEditedDate(today);
            userEntity.setEnteredBy(1);
            userEntity.setEnteredDate(today);

            userEntity.setEnabled(true);

            userEntity = userDao.save(userEntity);
            if (userEntity != null)
            {
                response = true;
            }
        }

        return response;
    }

    @Override
    public LoginResponseDTO login(LoginUserDTO loginUserDto)
    {
        LoginResponseDTO loginResponseDto = new LoginResponseDTO();

        String username = loginUserDto.getUsername();
        String password = loginUserDto.getPassword();
        UserEntity user = userDao.findUserByUsernameAndPassword(username, password);

        LocalDate today = LocalDate.now();

        List<BookDTO> bookDtoList = new ArrayList<BookDTO>();
        if (user != null)
        {
            // ============================================================================
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setCreated(LocalDateTime.now());
            tokenEntity.setToken(ShortUUID.shortUUID());
            tokenEntity.setUser(user);
            tokenEntity = tokenDao.save(tokenEntity);
            // ============================================================================
            loginResponseDto.setToken(tokenEntity.getToken());

            List<BookEntity> bookList = bookDao.findByUserId(user.getUserId());
            for (BookEntity book : bookList)
            {
                BookDTO bookDto = new BookDTO();
                bookDto.setBook(book);
                bookDto.setUser(user);

                bookDtoList.add(bookDto);
            }
            loginResponseDto.setBookList(bookDtoList);

        }

        return loginResponseDto;
    }

}

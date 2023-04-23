package com.tomholmes.products.library.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.products.library.model.TokenEntity;
import com.tomholmes.products.library.model.UserEntity;

public class TokenDaoImplTest extends BaseDaoTest
{
    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;

    private long _tokenId = 0;
    private long _userId = 1;
    private String _token = "fkasjfhl-ksdfhla-409724-flaskh";

    private TokenEntity save()
    {
        TokenEntity tokenEntity = new TokenEntity();

        tokenEntity.setTokenId(_tokenId);

        UserEntity user = new UserEntity();
        user.setUserId(_userId);
        tokenEntity.setUser(user);

        tokenEntity.setToken(_token);

        return tokenEntity;
    }

    // TokenEntity save(TokenEntity tokenEntity);
    @Test
    public void testTokensave()
    {
        System.out.println("testTokensave: START");

        TokenEntity tokenEntity = save();

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testTokensave: FINISH");
    }

    // TokenEntity updateTokenEntity(TokenEntity tokenEntity);
    @Test
    public void testTokenUpdate()
    {
        System.out.println("testTokenUpdate: START");

        TokenEntity tokenEntity = save();

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        String token = "upd-token-123456-abcd";
        tokenEntity.setToken(token);

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testTokenUpdate: FINISH");
    }

    // void deleteTokenEntity(long tokenId);
    // void deleteTokenEntity(TokenEntity tokenEntity);

    // TokenEntity getTokenEntity(long tokenId);
    @Test
    public void testGetTokenEntityById()
    {
        System.out.println("testGetTokenEntity: START");

        TokenEntity tokenEntity = save();

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        long tokenId = tokenEntity.getTokenId();
        tokenEntity = tokenDao.findById(tokenId).orElse(null);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testGetTokenEntity: FINISH");
    }

    // TokenEntity getTokenEntityByTokenname(String tokenname);
    @Disabled
    public void testGetTokenEntityByTokenUsername()
    {
        System.out.println("testGetTokenEntityByTokenUsername: START");

        TokenEntity tokenEntity = save();

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        String username = tokenEntity.getUser().getUsername();
        tokenEntity = tokenDao.findTokenEntityByUsername(username);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testGetTokenEntityByTokenUsername: FINISH");
    }

    @Test
    public void testGetTokenEntityByTokenUserId()
    {
        System.out.println("testGetTokenEntityByTokenUserId: START");

        TokenEntity tokenEntity = save();

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        long userId = tokenEntity.getUser().getUserId();
        tokenEntity = tokenDao.findTokenEntityByUserId(userId);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        System.out.println("testGetTokenEntityByTokenUserId: FINISH");
    }

    // List<TokenEntity> getAllTokenEntityList();
    @Test
    public void testGetAllTokenEntityList()
    {
        System.out.println("testGetAllTokenEntityList: START");

        TokenEntity tokenEntity = save();

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());

        // ===================================================================

        List<TokenEntity> tokenList = tokenDao.findAll();

        assertNotNull(tokenList);
        assertEquals(true, tokenList.size() > 0);

        System.out.println("testGetAllTokenEntityList: FINISH");
    }

    // TokenEntity getTokenEntityByTokenname(String tokenname);
    // @Test
    @Disabled
    public void testGetTokenEntityByTokenActiveUser()
    {
        System.out.println("testGetTokenEntityByTokenActiveUser: START");

        TokenEntity tokenEntity = save();
        tokenEntity.getUser().setEnabled(true);

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());
        assertEquals(true, tokenEntity.getUser().isEnabled());

        String token = tokenEntity.getToken();
        tokenEntity = tokenDao.findTokenEntityByToken(token);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());
        assertEquals(true, tokenEntity.getUser().isEnabled());

        System.out.println("testGetTokenEntityByTokenActiveUser: FINISH");
    }

    // TokenEntity getTokenEntityByTokenname(String tokenname);
    // @Test
    @Disabled
    public void testGetTokenEntityByTokenInActiveUser()
    {
        System.out.println("testGetTokenEntityByTokenInActiveUser: START");

        TokenEntity tokenEntity = save();

        // ====================================================
        UserEntity user = userDao.findById(_userId).orElse(null);
        user.setEnabled(false);
        user = userDao.save(user);
        // ====================================================
        tokenEntity.setUser(user);

        tokenEntity = tokenDao.save(tokenEntity);

        assertNotNull(tokenEntity);
        assertNotSame(0, tokenEntity.getTokenId());
        assertEquals(_token, tokenEntity.getToken());
        assertEquals(_userId, tokenEntity.getUser().getUserId());
        assertEquals(false, tokenEntity.getUser().isEnabled());

        String token = tokenEntity.getToken();
        tokenEntity = tokenDao.findTokenEntityByToken(token);

        assertNull(tokenEntity);

        System.out.println("testGetTokenEntityByTokenInActiveUser: FINISH");
    }

}

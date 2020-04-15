package org.bestsoft.jpa.service;


import org.bestsoft.jpa.entity.SysToken;
import org.bestsoft.jpa.entity.User;

import java.util.Map;

/**
 * @Author CrazyJay
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
public interface ShiroService {
     /**
      * Find user by username
      * @param username
      * @return
      */
     User findByUsername(String username);

     /**
      * create token by userId
      * @param userId
      * @return
      */
     Map<String,Object> createToken(Long userId);

     /**
      * logout
      * @param userId
      */
     void logout(Long userId);

     /**
      * find token by token
      * @param accessToken
      * @return
      */
     SysToken findByToken(String accessToken);

     /**
      * find user by userId
      * @param userId
      * @return
      */
     User findByUserId(Long userId);
}

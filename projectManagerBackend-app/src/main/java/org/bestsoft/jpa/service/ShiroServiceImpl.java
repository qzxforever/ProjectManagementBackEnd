package org.bestsoft.jpa.service;


import org.bestsoft.jpa.entity.SysToken;
import org.bestsoft.jpa.entity.User;
import org.bestsoft.jpa.repository.PermissionRepository;
import org.bestsoft.jpa.repository.RoleRepository;
import org.bestsoft.jpa.repository.SysTokenRepository;
import org.bestsoft.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author CrazyJay
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
@Service
public class ShiroServiceImpl implements ShiroService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private SysTokenRepository sysTokenRepository;

    /**
     * 根据username查找用户
     *
     * @param username
     * @return User
     */
    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    //12小时后过期
    private final static int EXPIRE = 3600 * 24;

    @Override
    /**
     * 生成一个token
     *@param  [userId]
     *@return Result
     */
    public Map<String,Object> createToken(Long userId) {
        Map<String,Object> result  = new HashMap<>();
        //生成一个token
        String token = "";
//                TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        SysToken tokenEntity = sysTokenRepository.findByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            sysTokenRepository.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            sysTokenRepository.save(tokenEntity);
        }
        result.put("token", token);
        result.put("expire", EXPIRE);
        return result;
    }

    @Override
    public void logout(Long userId) {
        //生成一个token
        String token = "";
//                TokenGenerator.generateValue();
        //修改token
        SysToken tokenEntity = new SysToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        sysTokenRepository.save(tokenEntity);
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return sysTokenRepository.findByToken(accessToken);

    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElseGet(User::new);
    }
}

package org.bestsoft.controller;


import org.apache.shiro.SecurityUtils;
import org.bestsoft.jpa.entity.User;
import org.bestsoft.jpa.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ShiroController {

    @Autowired
    private ShiroService shiroService;


    /**
     * 登录
     */
    @GetMapping("/sys/login")
    public Map<String, Object> login(String username, String password)  {
        Map<String, Object> result = new HashMap<>();
        //用户信息
        User user = shiroService.findByUsername(username);
        //账号不存在、密码错误
        if (user==null||!user.getPassword().equals(password)) {
            result.put("status", "400");
            result.put("msg", "账号或密码有误");
            return result;
        } else {
            //生成token，并保存到数据库

            result = shiroService.createToken(user.getId());
            result.put("status", "200");
            result.put("msg", "登陆成功");
            result.put("data",user);
            return result;
        }
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public Map<String, Object> logout() {
        Map<String, Object> result = new HashMap<>();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        shiroService.logout(user.getId());
        result.put("status", "200");
        result.put("msg", "登陆成功");
        return result;
    }
}



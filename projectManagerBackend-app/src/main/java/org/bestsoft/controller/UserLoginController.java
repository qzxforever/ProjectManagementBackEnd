package org.bestsoft.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.bestsoft.jpa.entity.User;
import org.bestsoft.utils.ShiroUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {
    /**
     * 登录
     */
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        //进行身份验证
        try{
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            //进行登录操作
            subject.login(token);
        }catch (IncorrectCredentialsException e) {
            map.put("code",500);
            map.put("msg","用户不存在或者密码错误");
            return map;
        } catch (LockedAccountException e) {
            map.put("code",500);
            map.put("msg","登录失败，该用户已被冻结");
            return map;
        } catch (AuthenticationException e) {
            map.put("code",500);
            map.put("msg","该用户不存在");
            return map;
        } catch (Exception e) {
            map.put("code",500);
            map.put("msg","未知异常");
            return map;
        }
        map.put("code",0);
        map.put("msg","登录成功");
        map.put("token", ShiroUtils.getSession().getId().toString());
        return map;
    }

    @RequiresRoles(value = {"admin"})
    @RequestMapping("/getLogout")
    public Map<String,Object> getLogout(){
        //登出Shiro会帮我们清理掉Session和Cache
        ShiroUtils.logout();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登出");
        return map;
    }
}
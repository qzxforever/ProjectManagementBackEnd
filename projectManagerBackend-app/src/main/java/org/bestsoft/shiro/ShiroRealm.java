package org.bestsoft.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.bestsoft.jpa.entity.Permission;
import org.bestsoft.jpa.entity.Role;
import org.bestsoft.jpa.entity.User;
import org.bestsoft.jpa.service.ShiroService;
import org.bestsoft.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description Shiro权限匹配和账号密码匹配
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户ID
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        //这里可以进行授权和处理
        //查询角色和权限(这里根据业务自行查询)
        for (Role role : user.getRoleSet()) {
            //2.1添加角色
            simpleAuthorizationInfo.addRole(role.getName());
            for (Permission permission : role.getPermissions()) {
                //2.1.1添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        return simpleAuthorizationInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        User user = shiroService.findByUsername(username);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        if (user.getStatus()==null||user.getStatus().equals("2")){
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getPassword(),                    //密码
                ByteSource.Util.bytes(user.getSalt()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(username,true);
        return authenticationInfo;
    }
}

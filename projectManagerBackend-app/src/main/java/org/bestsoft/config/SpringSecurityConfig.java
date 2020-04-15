package org.bestsoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**");
//                .antMatchers("/service/**")
//                .antMatchers("/healthCheck")
//                .antMatchers("/project/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").permitAll();
        http
            // 关闭csrf保护功能（跨域访问）
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/**").permitAll();//访问API下无需登录认证权限
    }
}

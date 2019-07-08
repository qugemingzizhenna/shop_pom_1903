package com.qf.shop_back;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.service.IBackUserService;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;


/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-04 17:24
 */
//1.与启动类同级并加configuration注解（springSecurity的配置）
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //2.重写配置方法
    @Reference
    private IBackUserService userService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.
               formLogin()
                    .loginPage("/tologin")
                        .loginProcessingUrl("/login")
                        .failureUrl("/tologin?error=1").permitAll()
               .and()
               .logout().permitAll()
               .and()
               .authorizeRequests()
                    //放行所有的静态资源
                    .mvcMatchers("/").authenticated()
                    .mvcMatchers("/resources/**").permitAll()
                    .anyRequest().access("@permissionHandler.hasPermission(request,authentication)")
               .and()
               .csrf().disable()
               //放行前端框架iframe
               .headers().frameOptions().sameOrigin()
               .and()
               //如果没有权限则跳转到一个错误页面
               .exceptionHandling().accessDeniedPage("/nopermisson");
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(NoOpPasswordEncoder.getInstance());


    }
}

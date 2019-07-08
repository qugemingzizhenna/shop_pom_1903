package com.qf.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-04 19:17
 */
@Component
public class PermissionHandler {

    public  boolean hasPermission(HttpServletRequest request, Authentication authentication){

        AntPathMatcher antPathMatcher = new AntPathMatcher();

        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            String requestURI = request.getRequestURI();
            System.out.println("----------------------->"+requestURI);
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                System.out.println("------------》"+authority.getAuthority());
                    if(antPathMatcher.match(authority.getAuthority(),requestURI)){
                        return true;
                    }
            }
        }
        return false;
    }
}

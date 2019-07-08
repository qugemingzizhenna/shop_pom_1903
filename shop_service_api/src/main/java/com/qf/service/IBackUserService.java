package com.qf.service;

import com.qf.entity.BackUser;
import com.qf.entity.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IBackUserService extends UserDetailsService {

    List<BackUser> queryAll();

    int insertUser(BackUser backUser);

    int deleteById(Integer id);

    int updateRoleByUid(Integer uid,Integer[] rid);



    /*BackUser login(String username,String password);*/

}

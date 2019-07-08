package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 表名 xxx_xxx -> XxxXxxx
 *
 * @version 1.0
 * @user ken
 * @date 2019/7/1 15:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackUser implements Serializable, UserDetails {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private Date createtime = new Date();
    private Integer status;
    //多表查询时配置用户对多（角色，权限）的属性
    @TableField(exist = false)
    private List<Role> roles;
    @TableField(exist = false)
    private List<Power> powers;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //有的角色没有权限，1.先判断根据用户名查到的权限集合是否为空登录
        if (powers!=null && powers.size()>0){
            for (Power power : powers) {
                //2.有的权限访问路径是空需要进行二次判断
                if(power.getPowerpath() !=null && !power.getPowerpath().equals("")){
                    authorities.add(new SimpleGrantedAuthority(power.getPowerpath()));
                }
            }
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

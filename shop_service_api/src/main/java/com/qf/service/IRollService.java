package com.qf.service;

import com.qf.entity.Power;
import com.qf.entity.Role;

import java.util.List;

public interface IRollService {
    List<Role> queryAllRole();

    int addRole(Role role);;

    int deleteRoolById(Integer id);

    List<Role> queryAllRoleByUid(Integer uid);

    int updateRolePower(Integer rid,Integer[] pids);

    List<Power> queryPowerByRid(Integer rid);
}

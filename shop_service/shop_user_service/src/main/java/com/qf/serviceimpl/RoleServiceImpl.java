package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.RoleMapper;
import com.qf.dao.RolePowerMapper;
import com.qf.entity.Power;
import com.qf.entity.Role;
import com.qf.entity.RolePowerTable;
import com.qf.service.IRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.0
 * @user
 * @date 2019-07-01 20:15
 */
@Service
public class RoleServiceImpl implements IRollService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePowerMapper rolePowerMapper;
    
    @Override
    public List<Role> queryAllRole() {

        List<Role> roles = roleMapper.selectList(null);

        return roles;
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int deleteRoolById(Integer id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public List<Role> queryAllRoleByUid(Integer uid) {
        return roleMapper.queryAllRoleByUid(uid);
    }

    @Override
    @Transactional
    public int updateRolePower(Integer rid, Integer[] pids) {
        //删除中间表中字段为rid的初始值
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("rid",rid);
        rolePowerMapper.delete(queryWrapper);
        //将传入的值重新插入中间表
        for (Integer pid : pids) {
            RolePowerTable rolePowerTable = new RolePowerTable(rid,pid);
            rolePowerMapper.insert(rolePowerTable);
        }
        return 1;
    }

    @Override
    public List<Power> queryPowerByRid(Integer rid) {
        return null;
    }
}

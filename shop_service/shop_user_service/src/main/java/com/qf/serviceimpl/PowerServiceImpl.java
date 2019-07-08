package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;

import com.qf.dao.PowerMapper;
import com.qf.entity.Power;
import com.qf.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-02 17:06
 */
@Service
public class PowerServiceImpl implements IPowerService {
    @Autowired
    private PowerMapper powerMapper;
    @Override
    public List<Power> queryAllPowers() {
        return powerMapper.queryAllPowers();
    }

    @Override
    public int insert(Power power) {
        return powerMapper.insert(power);
    }

    @Override
    public List<Power> queryPowerByRid(Integer rid) {
        return powerMapper.queryPowerByRid(rid);
    }
}

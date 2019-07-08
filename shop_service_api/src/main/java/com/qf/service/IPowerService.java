package com.qf.service;

import com.qf.entity.Power;

import java.util.List;

public interface IPowerService {

    int insert(Power power);
    List<Power> queryPowerByRid(Integer rid);
    List<Power> queryAllPowers();
}

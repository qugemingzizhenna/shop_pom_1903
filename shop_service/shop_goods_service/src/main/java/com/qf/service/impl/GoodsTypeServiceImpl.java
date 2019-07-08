package com.qf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GoodsTypeMapper;
import com.qf.entity.GoodsType;
import com.qf.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user
 * @date 2019-07-05 19:12
 */
@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> queryAllType() {
        return goodsTypeMapper.queryAllType();
    }

    @Override
    public int insertType(GoodsType goodsType) {
        return goodsTypeMapper.insert(goodsType);
    }
}

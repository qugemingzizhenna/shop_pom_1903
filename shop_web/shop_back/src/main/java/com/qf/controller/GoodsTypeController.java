package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.GoodsType;
import com.qf.service.IGoodsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-05 19:52
 *
 */
@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {
    @Reference
    private IGoodsTypeService goodsTypeService;


    @RequestMapping("/list")
    public String listGoodsType(Model model){
        List<GoodsType> goodsTypes = goodsTypeService.queryAllType();
        model.addAttribute("goodsTypes",goodsTypes);
        return "listGoodsType";
    }

    @RequestMapping("/listAjax")
    @ResponseBody
    public List<GoodsType> listAjax(){
        return goodsTypeService.queryAllType();
    }

    @RequestMapping("/insert")
    public String insertType(GoodsType goodsType){
        goodsTypeService.insertType(goodsType);
        return "redirect:/goodsType/list";
    }
}

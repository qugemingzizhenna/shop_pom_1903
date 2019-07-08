package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Power;
import com.qf.service.IPowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-02 16:50
 */
@Controller
@RequestMapping("/power")
public class PowerController {

    @Reference
    private IPowerService powerService;

    @RequestMapping("/list")
    public String queryAllPowers(Model model){
        List<Power> powers = powerService.queryAllPowers();
        model.addAttribute("powers",powers);
        return  "powerList";
    }
    /*
    显示父类请求
    */
    @RequestMapping("/listAjax")
    @ResponseBody
    public List<Power> listAjax(){
        return powerService.queryAllPowers();
    }

    @RequestMapping("/insert")
    public String insertPower(Power power){
        powerService.insert(power);
        return "redirect:/power/list";
    }

    @RequestMapping("/queryPowerByRid")
    @ResponseBody
    public List<Power> queryPowerByRid(Integer rid){
        return powerService.queryPowerByRid(rid);
    }
}

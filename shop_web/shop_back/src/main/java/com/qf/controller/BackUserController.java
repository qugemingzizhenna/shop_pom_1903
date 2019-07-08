package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.service.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * 后台用户的controller
 * @version 1.0
 * @user ken
 * @date 2019/7/1 15:08
 */
@Controller
@RequestMapping("/buser")
public class BackUserController {

    @Reference
    private IBackUserService backUserService;

    /**
     * 查询后台用户的列表数据
     * @return
     */
    @RequestMapping("/list")
    public String userList(Model model){

        //调用后台服务，查询列表
        List<BackUser> backUsers = backUserService.queryAll();
        model.addAttribute("users", backUsers);

        return "buserlist";
    }

    /**
     * 添加用户
     * @param backUser
     * @return
     */
    @RequestMapping("/insert")
    public String userAdd(BackUser backUser){
        backUserService.insertUser(backUser);
        return "redirect:/buser/list";
    }

    /*删除用户*/
    @RequestMapping("/delete/{id}")
    public  String deleteById(@PathVariable Integer id){
        System.out.println(id);
        backUserService.deleteById(id);
        return "redirect:/buser/list";
    }

    @RequestMapping("/updateRole")
    public String updateRole(Integer uid, Integer[] rid){
        System.out.println(uid+"---->"+ Arrays.toString(rid));
        backUserService.updateRoleByUid(uid,rid);
        return "redirect:/buser/list";
    }
}

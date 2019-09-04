package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.entity.Role;
import com.qf.service.IBackUserService;
import com.qf.service.IRollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-01 18:48
 * 测试代码提交
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Reference
    private IRollService rollService;
    @RequestMapping("/list")
    public String listRole(Model model){
        List<Role> roles = rollService.queryAllRole();

        model.addAttribute("roles",roles);
        return "roleList";
    }

    @RequestMapping("/addRole")
    public String addRole(Role role){
        rollService.addRole(role);
        return  "redirect:/role/list";
    }
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        rollService.deleteRoolById(id);
        return  "redirect:/role/list";
    }
    @RequestMapping("/listAjax")
    @ResponseBody
    public List<Role> listAjax(Integer uid){

        List<Role> roles = rollService.queryAllRoleByUid(uid);
        System.out.println(roles);
        return roles;
    }

    @RequestMapping("/updateRolePower")
    @ResponseBody
    public String updateRolePower(Integer rid,@RequestParam("pids[]") Integer[] pids){
        System.out.println("rid:"+rid+"---->"+ Arrays.toString(pids));
        rollService.updateRolePower(rid,pids);
        return "success";
    }


}

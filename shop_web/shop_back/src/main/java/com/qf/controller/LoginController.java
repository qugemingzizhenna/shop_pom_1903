package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.service.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @version 1.0
 * @user ken
 * @date 2019/7/1 14:46
 */
@Controller
@SessionAttributes("loginUser")
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @Reference
    private IBackUserService backUserService;
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/nopermisson")
    public String errorPageMethod(){
        return "nopermisson";
    }

    /**
     * 进行登录
     * @return
     */
  /*  @RequestMapping("/login")
    public String login(String username, String password, Model model){
        将登录返回的对象放到session中
        BackUser backUser = backUserService.login(username, password);
        System.out.println(backUser);
        if(backUser!=null){
            model.addAttribute("loginUser",backUser);
            return "index";
        }else{
            return "redirect:/tologin?error=1";
        }

    }*/
}

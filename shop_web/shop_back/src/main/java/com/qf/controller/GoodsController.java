package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Goods;
import com.qf.service.IGoodsService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @version 1.0
 * @user yzb
 * @date 2019-07-06 9:20
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    private IGoodsService goodsService;
    //图片上传的位置，在取yml配置文件中的路径值
    @Value("${upload.path}")
    private  String uploadPath;

    @RequestMapping("/list")
    public String listGoods(Model model){
        List<Goods> goods = goodsService.queryAll();
        model.addAttribute("goods",goods);
        return "goodsList";
    }

    @RequestMapping("uploadImg")
    @ResponseBody
    public String uploadIma(MultipartFile file){
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //定义一个文件上传的路径
        String filePath = "";
        //获取文件名中.的下标
        int index = originalFilename.lastIndexOf(".");
        //根据下标截取得到上传文件的后缀并在文件前加入一个UUID
        System.out.println(originalFilename.substring(index));
        String fileName = UUID.randomUUID()+originalFilename.substring(index);
        filePath = uploadPath + fileName;

        try(
                //打开文件的输入流
                InputStream inputStream = file.getInputStream();
                //文件要拷贝到的路径
               OutputStream outputStream = new FileOutputStream(filePath);
                ) {
                    IOUtils.copy(inputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filePath);
        return "{\"filePath\":\""+filePath+"\"}";
    }

    @RequestMapping("/insert")
    public String insertGoods(Goods goods){
        goodsService.insertGoods(goods);
        return "redirect:/goods/list";
    }

    @RequestMapping("/getImgs")
    public void getImage(String imagepath, HttpServletResponse response){
        File file = new File(imagepath);
        try(
                InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = response.getOutputStream();
                ) {
            IOUtils.copy(inputStream,outputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

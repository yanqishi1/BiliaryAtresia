package com.biliaryatresia.controller;

import com.biliaryatresia.service.AccountService;
import com.biliaryatresia.service.VcodeService;
import com.biliaryatresia.util.Pager;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;


@Api(tags = "登录注册功能接口")
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    VcodeService vcodeService = null;

    @Autowired
    AccountService accountService = null;
    /**
     * 获取验证码
     */
    @GetMapping("/code")
    public void vcodeGet(@RequestParam(value = "ts",required = false) String ts,
                         HttpSession session, HttpServletResponse response){

        response.setContentType("image/jpeg");
        //将得到的随机字符串放到session中
        String randomString  = vcodeService.getRandomString();
        session.setAttribute("vcode",randomString);
        //得到图片
        BufferedImage bi = vcodeService.getImage(randomString);

        try {
            ImageIO.write(bi, "JPEG", response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param account 电话号码
     * @param password 密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.POST})
    public Pager login(String account, String password){
        return accountService.login(account, password);
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Pager register(String account,
                          String password,
                          String code,
                          HttpSession session){
        return accountService.register(account, password);
//        String vcode = (String)session.getAttribute("checkcode");
//        if(code!=null && code.equals(vcode)){
//            return accountService.register(account, password);
//        }else{
//            return new Pager(500, "Error");
//        }
    }

}

package com.biliaryatresia.controller;

import com.biliaryatresia.service.AccountService;
import com.biliaryatresia.service.VcodeService;
import com.biliaryatresia.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Api(tags = "登录注册功能接口")
@RestController
@CrossOrigin
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
    public Msg login(String account, String password, HttpSession session){
        return accountService.login(account, password, session);
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Msg register(String account,
                        String password,
                        String code,
                        HttpSession session){
        String vcode = (String)session.getAttribute("vcode");
        if(code!=null && code.equals(vcode)){
            return accountService.register(account, password);
        }else{
            return new Msg(500, "Error");
        }
    }

}

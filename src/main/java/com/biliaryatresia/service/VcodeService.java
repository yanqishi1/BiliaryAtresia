package com.biliaryatresia.service;

import java.awt.image.BufferedImage;

/**
 * @author yanqishi1
 * 定义验证码的各种操作
 */
public interface VcodeService {

    /**
     * 获取一个随机字符串
     * @return
     */
    String getRandomString();

    /**
     * 根据随机字符串得到一个验证码图片
     * @param randomString
     * @return
     */
    BufferedImage getImage(String randomString);

    /**
     * 检查前端传过来的验证码是否正确
     * @param vcode 前端验证码
     * @param checkcode 后端保存的验证码
     * @return 返回是否正确
     */
    Integer check(String vcode, String checkcode);

    /**
     * 发送邮箱验证码
     * @param address 接收者的邮箱地址
     * @param code 发送的验证码内容
     * @return 返回是否发送成功
     */
    Boolean sendMail(String address, String code);

    /**
     * 发送短信验证码
     * @param tel 接收者的电话号码
     * @param code 验证码内容
     * @return 返回是否发送成功
     */
    Boolean sendPhoneMessage(String tel, String code);
}

package com.biliaryatresia.service;

import com.biliaryatresia.util.Msg;

import javax.servlet.http.HttpSession;

public interface AccountService {
    public Msg login(String tel, String password, HttpSession session);

    public Msg register(String tel, String password);
}

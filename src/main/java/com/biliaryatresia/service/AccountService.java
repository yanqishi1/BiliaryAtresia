package com.biliaryatresia.service;

import com.biliaryatresia.util.Pager;
import org.springframework.stereotype.Service;

public interface AccountService {
    public Pager login(String tel, String password);

    public Pager register(String tel, String password);
}

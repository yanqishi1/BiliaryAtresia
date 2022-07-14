package com.biliaryatresia.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pager {

    private Integer code;

    private String msg;

    public Pager(){}

    public Pager(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

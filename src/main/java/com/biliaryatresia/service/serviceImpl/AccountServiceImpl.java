package com.biliaryatresia.service.serviceImpl;

import com.biliaryatresia.entity.ImageLog;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.entity.Reserve;
import com.biliaryatresia.mapper.ImageLogMapper;
import com.biliaryatresia.mapper.PatientMapper;
import com.biliaryatresia.mapper.ReserveMapper;
import com.biliaryatresia.service.AccountService;
import com.biliaryatresia.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    PatientMapper patientMapper = null;

    @Autowired
    ImageLogMapper imageMapper;

    @Autowired
    ReserveMapper reserveMapper;

    @Override
    public Msg login(String tel, String password, HttpSession session) {
        Msg pager = new Msg();
        Patient patient = patientMapper.queryByTel(tel);
        if(patient!=null){
            if(password!=null && password.equals(patient.getPPassword())){
                session.setAttribute("patient", patient);
                patient.setPPassword(null);
                pager.setCode(200);
                pager.setMsg("Login Succcess!");
                pager.setObject(patient);
            }
        }else{
            pager.setCode(501);
            pager.setMsg("Password Incorrect!");
        }
        return pager;
    }

    @Override
    public Msg register(String tel, String password) {
        Msg pager = new Msg();
        Patient patient = patientMapper.queryByTel(tel);
        if(patient==null){
            Patient p = new Patient();
            p.setPTel(tel);
            p.setPPassword(password);
            p.setPDate(new Date());
            patientMapper.register(p);
            pager.setCode(200);
            pager.setMsg("Register Succcess!");
        }else{
            pager.setCode(501);
            pager.setMsg("User Exit");
        }
        return pager;
    }

    @Override
    public Msg getRecord(Integer pid) {
        Msg msg = new Msg();
        try {
            Map<String,Object> map = new HashMap<>();
            List<ImageLog> detects = imageMapper.queryByPid(pid);
            List<Reserve> reserves= reserveMapper.queryByPid(pid);
            map.put("detects", detects);
            map.put("reserves", reserves);
            msg.setCode(200);
            msg.setMsg("get success");
            msg.setObject(map);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setCode(500);
            msg.setMsg("Get error");
        }
        return msg;
    }
}

package com.biliaryatresia.service.serviceImpl;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.mapper.PatientMapper;
import com.biliaryatresia.service.AccountService;
import com.biliaryatresia.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    PatientMapper patientMapper = null;
    @Override
    public Msg login(String tel, String password, HttpSession session) {
        Msg pager = new Msg();
        Patient patient = patientMapper.queryByTel(tel);
        if(patient!=null){
            if(password!=null && password.equals(patient.getPPassword())){
                session.setAttribute("patient", patient);
                pager.setCode(200);
                pager.setMsg("Login Succcess!");
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
}

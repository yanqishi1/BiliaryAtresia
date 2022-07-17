package com.biliaryatresia.service.serviceImpl;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.mapper.PatientMapper;
import com.biliaryatresia.service.AccountService;
import com.biliaryatresia.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    PatientMapper patientMapper = null;
    @Override
    public Pager login(String tel, String password) {
        Pager pager = new Pager();
        Patient patient = patientMapper.queryByTel(tel);
        if(patient!=null){
            if(password!=null && password.equals(patient.getPPassword())){
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
    public Pager register(String tel, String password) {
        Pager pager = new Pager();
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

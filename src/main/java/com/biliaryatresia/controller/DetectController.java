package com.biliaryatresia.controller;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.service.DetectService;
import com.biliaryatresia.util.Pager;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Api(tags = "检测接口")
@RestController
@CrossOrigin
@RequestMapping("/api/detect")
public class DetectController {

    @Autowired
    DetectService detectService = null;

    @ResponseBody
    @PostMapping("/upload")
    public Pager detectBA(MultipartFile file, HttpSession session){
        Patient patient = new Patient();
        patient.setPId(10);
        return detectService.detectBA(file, patient);
//        Patient patient = (Patient) session.getAttribute("patient");
//        if(patient!=null){
//            return detectService.detectBA(img, patient);
//        }else{
//            return new Pager(500, "No patient or Not login");
//        }
    }
}

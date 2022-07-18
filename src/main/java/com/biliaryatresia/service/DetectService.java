package com.biliaryatresia.service;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.util.Msg;
import org.springframework.web.multipart.MultipartFile;

public interface DetectService {
    public Msg detectBA(MultipartFile file, Patient patient);
}

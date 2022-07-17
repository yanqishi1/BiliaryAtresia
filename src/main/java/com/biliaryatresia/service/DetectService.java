package com.biliaryatresia.service;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.util.Pager;
import org.springframework.web.multipart.MultipartFile;

public interface DetectService {
    public Pager detectBA(MultipartFile file, Patient patient);
}

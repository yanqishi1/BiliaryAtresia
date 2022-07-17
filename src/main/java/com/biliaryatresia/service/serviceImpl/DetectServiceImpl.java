package com.biliaryatresia.service.serviceImpl;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.listener.ApplicationConstants;
import com.biliaryatresia.service.DetectService;
import com.biliaryatresia.util.Pager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
public class DetectServiceImpl implements DetectService {

    final String [] results = {"严重异常","异常","可疑","正常"};
    @Override
    public Pager detectBA(MultipartFile file, Patient patient) {
        Pager pager = new Pager();
        //检查pid文件夹是否存在
        try {
            String folder = ApplicationConstants.projectPath+"upload"+File.separator+patient.getPId();
            File dir = new File(folder);
            if(!dir.exists()){
                dir.mkdirs();
            }

            String p = folder+ File.separator+file.getOriginalFilename();
            File sf = new File(p);
            file.transferTo(sf);
            //检测
            //.....

            //检测结果
            Random random = new Random();
            pager.setCode(200);
            pager.setMsg(results[random.nextInt(4)]);
        } catch (IOException e) {
            pager.setCode(500);
            pager.setMsg("File IO Error");
            throw new RuntimeException(e);
        }
        return pager;
    }
}

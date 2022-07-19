package com.biliaryatresia.config;

import com.biliaryatresia.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class ScheduleTask {

    @Autowired
    AppointmentService appointmentService = null;
    private boolean init = true;//初始化标志

    @Scheduled(fixedDelay = 1000*60*60*24)//每天执行一次
    private void configureTasks(){
        System.out.println(LocalDateTime.now()+"Auto Assignments");
        appointmentService.assignments(init);
        if(init) init = false;
    }
}

package com.biliaryatresia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ServletComponentScan
public class BiliaryAtresiaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BiliaryAtresiaApplication.class, args);
    }


}

package com.biliaryatresia.interceptor;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectJ {

//    @Before("execution(* com.biliaryatresia.controller.AccountController.*(..) )")
//    public void BeforeLog(){
//        System.out.println("Before log....");
//    }
//
//    @After("execution(* com.biliaryatresia.controller.AccountController.*(..) )")
//    public void AfterLog(){
//        System.out.println("After log....");
//    }
}

package com.starproject.waa.homeworks.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

//    @Pointcut("execution(* com.starproject.waa.homeworks.controller.UserController.*(..))")
//    public void logMe(){
//
//    }
//
//    @Before("logMe()")
//    public void logBefore(JoinPoint joinPoint){
//        System.out.println("Before" + joinPoint.getSignature().getName());
//    }
//
//    @After("logMe()")
//    public void logAfter(JoinPoint joinPoint){
//        System.out.println("After" + joinPoint.getSignature().getName());
//    }
}

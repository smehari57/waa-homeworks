package com.starproject.waa.homeworks.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

//    @Pointcut("execution(* com.starproject.waa.homeworks.controller.UserController.getUserById(..))")
//    public void logMe() {
//
//    }
//
//    @Before("logMe()")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Before" + joinPoint.getSignature().getName());
//    }
//
//    @After("logMe()")
//    public void logAfter(JoinPoint joinPoint) {
//        System.out.println("After" + joinPoint.getSignature().getName());
//    }
//
//    @Around("logMe()")
//    public void logAround (ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("This is Around  " + joinPoint.getSignature().getName());
//        joinPoint.proceed();
//        System.out.println("This is After Around  " + joinPoint.getSignature().getName());
//
//    }
}

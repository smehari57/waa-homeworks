package com.starproject.waa.homeworks.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    long start;
    long end;
    long timeTaken;

    @Pointcut("@annotation(com.starproject.waa.homeworks.Aspect.ExecutionTme)")
    public void timeAnnotaion(){

    }

    @Before("timeAnnotaion()")
    public void logBefore(JoinPoint joinPoint){
        start = System.currentTimeMillis();
    }

    @After("timeAnnotaion()")
    public void logAfter(JoinPoint joinPoint){
        end = System.currentTimeMillis();
        timeTaken = end - start;
        System.out.println("Time taken for " + joinPoint.getSignature().getName() + " is : " + timeTaken + " milliseconds");
    }
}

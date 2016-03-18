package com.demo.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by yy on 2016/3/10.
 */
//@Aspect
@Component("aop1")
public class AopHelper2 {
    @Pointcut("execution(* com.demo.service.impl.*.*(..))")
    public void cutPoint(){}

    @Before("cutPoint()")
    public void beforeCut(JoinPoint joinPoint){
        System.out.println("-- Before PointCut2 --");
    }

    @After("cutPoint()")
    public void afterCut(){
        System.out.println("-- After PointCut2 --");
    }

    @AfterReturning(pointcut = "cutPoint()",returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, Object retVal){
        System.out.println("-- After Retuning2 --" + retVal);
    }

    @AfterThrowing(pointcut = "cutPoint()",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("-- After Throwing2 --");
        ex.printStackTrace();
    }

    @Around("cutPoint()")
    public Object aroundCut(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-- Before Around2 --");
        Object obj = joinPoint.proceed();
        System.out.println("-- After Around2 --");
        return obj;
    }
}

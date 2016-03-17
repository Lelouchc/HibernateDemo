package com.demo.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by yy on 2016/3/9.
 */
@Aspect
@Component("aop2")
public class AopHelper {
    @Pointcut("execution(* com.demo.service.impl.*.*(..))")
    public void cutPoint() {
    }

    @Before("cutPoint()")
    public void beforeCut(JoinPoint joinPoint) {
        System.out.println("-- Before PointCut --");
//        Object[] objects = joinPoint.getArgs();
//        for(Object o : objects){
//            System.out.println(o);
//        }
    }

    @After("cutPoint()")
    public void afterCut() {
        System.out.println("-- After PointCut --");
    }

    @AfterReturning(pointcut = "cutPoint()", returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, Object retVal) {
        System.out.println("-- After Retuning --" + retVal);
    }

    @AfterThrowing(pointcut = "cutPoint()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("-- After Throwing --");
        ex.printStackTrace();
    }

    @Around("cutPoint()")
    public Object aroundCut(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-- Before Around --");
        Object obj = joinPoint.proceed();
        System.out.println("-- After Around --");
        return obj;
    }
}

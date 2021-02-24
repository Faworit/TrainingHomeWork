package com.epam.ryabtsev.aspect;
import com.epam.ryabtsev.controller.NewsController;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {
    private static final Logger log = Logger.getLogger(NewsController.class.getName());

    @Pointcut("execution(* com.epam.ryabtsev.controller.*.*(..))")
    public void controllerLog() {
    }

    @Before("controllerLog()")
    public void startMethodLog(JoinPoint joinPoint) {
        log.warn(" Start in class: " + joinPoint.getTarget().getClass().getName() +
                ", method: " + joinPoint.getSignature().getName());

    }

    @Before(value = "@annotation(com.epam.ryabtsev.controller.Monitor)")
    public void logAnnotation(JoinPoint joinPoint) {
        log.warn("Start method with custom annotation: class:  " + joinPoint.getSignature().getDeclaringType().getSimpleName()
                + ", method: " + joinPoint.getSignature().getName());

    }

    @After("controllerLog()")
    public void logAfter(JoinPoint joinPoint) {
        log.warn("finish in class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() +
                ", finish mothod: " + joinPoint.getSignature().getName());
    }
}

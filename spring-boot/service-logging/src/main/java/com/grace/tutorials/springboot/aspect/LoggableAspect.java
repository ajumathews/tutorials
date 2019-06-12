package com.grace.tutorials.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggableAspect {

    private final Logger LOGGER;

    public LoggableAspect(String loggerName){
        super();
        LOGGER = LoggerFactory.getLogger(loggerName);
    }

    @Pointcut("@annotation(Timed)")
    public void executeLogging(){}

    @Around("executeLogging()")
    public Object loggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis()-startTime;
        LOGGER.info("Method "+ proceedingJoinPoint.getSignature().getName() + " completed in  "+timeTaken +" ms" );
        return returnValue;
    }
}

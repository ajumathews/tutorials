package com.grace.tutorials.spring.orderapp_aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
        System.out.println("executeLogging");
    }

    @Before("executeLogging()")
    public void beforLogMethodCall(JoinPoint joinPoint) {
        final StringBuilder message = new StringBuilder("Method : ");
        message.append(joinPoint.getSignature().getName());
        final Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            message.append("args : [");

            Arrays.asList(args).stream().forEach(arg -> {
                message.append("arg : ").append(arg).append("|");
            });

            message.append("]");

        }
        System.out.println(message.toString());
        LOGGER.info(message.toString());
    }


    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
    public void afterLogMethodCall(JoinPoint joinPoint, Object returnValue){
        System.out.println(joinPoint.getSignature().getName() + " output :" +returnValue);
    }


    @Around("executeLogging()")
    public Object aroundLogMethodCall(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;

        System.out.println("Time taken for Method "+ joinPoint.getSignature().getName() + " :" +timeTaken +"ms ");
        return returnValue;
    }
}

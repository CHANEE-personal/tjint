package com.tjint.springboot.common.annotation;

import org.apache.commons.lang.time.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class Logging {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* app..*Controller.*(..)) || execution(* egovframework..*Controller.*(..))")
    public void loggingPointcut() {}

    @Around("loggingPointcut()")
    public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        Object thisObj = joinPoint.getTarget();
        String className = thisObj.getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        long currentTime = System.currentTimeMillis();
        if (this.logger.isDebugEnabled())
            this.logger.debug("==================== START " + className + " - " + methodName + "() : {} ====================", DateUtils.getDateString(new Date(), "yyyy-MM-dd HH:mm:ss"));
        Object returnObj = joinPoint.proceed();
        if (this.logger.isDebugEnabled())
            this.logger.debug("==================== END Time: {}ms ============================================================", new Object[] { Long.valueOf(System.currentTimeMillis() - currentTime) });
        return returnObj;
    }

    @Before("loggingPointcut()")
    public void beforeController() {}

    @After("loggingPointcut()")
    public void afterController() {}
}

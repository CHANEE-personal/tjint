package com.tjint.springboot.common.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Pointcut("execution(* app..*Controller.*(..)) || execution(* egovframework..*Controller.*(..))")
//    public void loggingPointcut() {}
//
//    @Around("loggingPointcut()")
//    public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object thisObj = joinPoint.getTarget();
//        String className = thisObj.getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        long currentTime = System.currentTimeMillis();
//        if (this.logger.isDebugEnabled())
//            this.logger.debug("==================== START " + className + " - " + methodName + "() : {} ====================", DateUtil.getDateString(new Date(), "yyyy-MM-dd HH:mm:ss"));
//        Object returnObj = joinPoint.proceed();
//        if (this.logger.isDebugEnabled())
//            this.logger.debug("==================== END Time: {}ms ============================================================", new Object[] { Long.valueOf(System.currentTimeMillis() - currentTime) });
//        return returnObj;
//    }
//
//    @Before("loggingPointcut()")
//    public void beforeController() {}
//
//    @After("loggingPointcut()")
//    public void afterController() {}
}

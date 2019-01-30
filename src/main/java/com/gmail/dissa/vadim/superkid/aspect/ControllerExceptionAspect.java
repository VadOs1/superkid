package com.gmail.dissa.vadim.superkid.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerExceptionAspect {

    private final Logger logger;

    public ControllerExceptionAspect() {
        logger = Logger.getLogger(ControllerExceptionAspect.class);
    }

    public ControllerExceptionAspect(Logger logger) {
        this.logger = logger;
    }

    // Catching all exceptions from all methods in all controllers classes
    @AfterThrowing(pointcut = "execution(* com.gmail.dissa.vadim.superkid..controller..*(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        logger.error("CONTROLLER ASPECT: EXCEPTION IN METHOD -> " + exception.getClass());
    }
}

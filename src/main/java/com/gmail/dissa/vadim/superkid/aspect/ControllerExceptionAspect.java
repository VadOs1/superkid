package com.gmail.dissa.vadim.superkid.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerExceptionAspect {
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionAspect.class);

    // Catching all exceptions from all methods in all controllers classes
    @AfterThrowing(pointcut = "execution(* com.gmail.dissa.vadim.superkid..controller..*(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        logger.error("CONTROLLER ASPECT: EXCEPTION IN METHOD -> " + exception.getClass());
    }
}

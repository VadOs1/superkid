package com.gmail.dissa.vadim.superkid.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@Aspect
public class ControllerExceptionAspect {

    // Catching all exceptions from all methods in all controllers classes
    @AfterThrowing(pointcut = "execution(* com.gmail.dissa.vadim.superkid..controller..*(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        log.error("CONTROLLER ASPECT: EXCEPTION IN METHOD -> " + exception.getClass());
    }
}

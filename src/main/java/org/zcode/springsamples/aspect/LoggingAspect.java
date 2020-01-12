package org.zcode.springsamples.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggingAspect {

    public static final String START_LOGGING = "*** START LOGGING ****";
    public static final String END_LOGGING = "*** END LOGGING ****";

    @Autowired
    private Logger logger;

    @Autowired(required = false)
    private HttpServletRequest httpServletRequest;

    @Around("@annotation(org.zcode.springsamples.aspect.Loggable)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object object = null;
        logger.log(START_LOGGING);
        logger.logRequest(httpServletRequest);
        object = proceedingJoinPoint.proceed();
        logger.log(END_LOGGING);
        return object;
    }
}



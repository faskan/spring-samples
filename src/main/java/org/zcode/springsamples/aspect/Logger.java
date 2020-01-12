package org.zcode.springsamples.aspect;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class Logger {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public void logRequest(HttpServletRequest httpServletRequest){
        logger.info(httpServletRequest.getMethod() + httpServletRequest.getRequestURI());
    }

    public void log(String message){
        logger.info(message);
    }
}

package org.zcode.springsamples.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.zcode.springsamples.aspect.LoggingAspect.END_LOGGING;
import static org.zcode.springsamples.aspect.LoggingAspect.START_LOGGING;

@ExtendWith(MockitoExtension.class)
public class LoggingAspectTest {

    @Mock
    Logger logger;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    ProceedingJoinPoint proceedingJoinPoint;

    @InjectMocks
    LoggingAspect loggingAspect;

    @Test
    public void testIfLoggersAreCalled() throws Throwable {
        when(proceedingJoinPoint.proceed()).thenReturn("something");
        loggingAspect.log(proceedingJoinPoint);
        verify(logger, times(1)).log(START_LOGGING);
        verify(logger, times(1)).logRequest(httpServletRequest);
        verify(logger, times(1)).log(END_LOGGING);
    }

}
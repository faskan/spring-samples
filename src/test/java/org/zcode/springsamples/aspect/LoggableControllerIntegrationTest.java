package org.zcode.springsamples.aspect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.zcode.springsamples.aspect.LoggingAspect.END_LOGGING;
import static org.zcode.springsamples.aspect.LoggingAspect.START_LOGGING;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoggableControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @SpyBean
    private Logger logger;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void logme() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:" + port + "/logme", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("hello world", response.getBody());
        verify(logger).log(START_LOGGING);
        verify(logger).logRequest(any());
        verify(logger).log(END_LOGGING);
    }
}
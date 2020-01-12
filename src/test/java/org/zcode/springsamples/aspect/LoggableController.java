package org.zcode.springsamples.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoggableController {

    @GetMapping("/logme")
    @Loggable
    public String logme(){
        return "hello world";
    }
}

package org.zcode.springsamples.resttemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestClient {

    private RestTemplate restTemplate;

    public MyRestClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getResponse() {
        return restTemplate.getForObject("/dummy", String.class);
    }
}

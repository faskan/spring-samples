package org.zcode.springsamples.resttemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@RestClientTest(MyRestClient.class)
public class MyRestClientTest {

    @Autowired
    MyRestClient myRestClient;

    @Autowired
    MockRestServiceServer mockRestServiceServer;

    @BeforeEach
    public void setUp() {
        mockRestServiceServer.expect(requestTo("/dummy"))
                .andRespond(withSuccess("Hello!", MediaType.TEXT_PLAIN));

    }

    @Test
    void getResponse() {
        String response = myRestClient.getResponse();
        assertThat(response).isEqualTo("Hello!");
    }
}
package com.example.assignment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@AutoConfigureWireMock(port = 8080)
public class WireMockTest {


    @Test
    void timeout(){
        WireMock.stubFor(get(urlEqualTo("/cf/")).willReturn(
                aResponse()
                        .withStatus(200)
                        .withFixedDelay(2000)));
    }
}

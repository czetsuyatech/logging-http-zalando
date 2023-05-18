package com.czetsuyatech.logging.web.controllers;

import com.czetsuyatech.logging.web.models.Computer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoggingController {

  private final RestTemplate restTemplate;

  @GetMapping("/logs/internal-requests")
  public void logBody() {

    log.debug("Logging internal request");

    restTemplate.getForEntity("http://localhost:8080/call-me", Computer.class);
  }

  @GetMapping("/call-me")
  public Computer callMe() {
    log.debug("calling internal url");

    return Computer.builder()
        .brand("Apple")
        .model("Macbook Pro")
        .cpu("M2")
        .ram(32)
        .build();
  }
}

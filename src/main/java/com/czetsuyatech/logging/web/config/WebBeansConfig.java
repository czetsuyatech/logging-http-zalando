package com.czetsuyatech.logging.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

@Configuration
@RequiredArgsConstructor
public class WebBeansConfig {

  private final Logbook logbook;

  @Bean
  public RestTemplate restTemplate() {

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getInterceptors().add(getLogbookInterceptor());

    return restTemplate;
  }

  private LogbookClientHttpRequestInterceptor getLogbookInterceptor() {
    return new LogbookClientHttpRequestInterceptor(logbook);
  }
}

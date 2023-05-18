package com.czetsuyatech.logging.web.config;

import com.czetsuyatech.logging.web.logging.LogFormatter;
import com.czetsuyatech.logging.web.logging.LogSink;
import com.czetsuyatech.logging.web.logging.LogWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.core.StatusAtLeastStrategy;

@Configuration
public class LoggingBeansConfig {

  // mappers, services, and repositories can be injected here and pass down to the formatter when needed

  @Bean
  public Logbook getLogbook() {
    return Logbook.builder()
        .strategy(new StatusAtLeastStrategy(200))
        .sink(new LogSink(new LogFormatter(), new LogWriter()))
        .build();
  }
}

package com.czetsuyatech.logging.web.logging;

import com.czetsuyatech.logging.web.models.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogWriter {

  // you can autowire a service here
  public void write(Message message) {
    log.debug("Http intercepted message={}", message);
  }
}

package com.czetsuyatech.logging.web.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

  private String correlationId;
  private String requestBody;
  private String responseBody;
}

package com.czetsuyatech.logging.web.logging;

import com.czetsuyatech.logging.web.models.Message;
import java.io.IOException;
import org.zalando.logbook.HttpRequest;
import org.zalando.logbook.HttpResponse;

public class LogFormatter {

  public Message format(String correlationId, HttpRequest request, HttpResponse response) throws IOException {

    return Message.builder()
        .correlationId(correlationId)
        .requestBody(request.getBodyAsString())
        .responseBody(response.getBodyAsString())

        .build();
  }
}

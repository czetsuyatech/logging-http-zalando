package com.czetsuyatech.logging.web.logging;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpRequest;
import org.zalando.logbook.HttpResponse;
import org.zalando.logbook.Precorrelation;
import org.zalando.logbook.Sink;

@RequiredArgsConstructor
public class LogSink implements Sink {

  private final LogFormatter formatter;
  private final LogWriter writer;

  @Override
  public void write(Precorrelation preCorrelation, HttpRequest request) throws IOException {

  }

  @Override
  public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {

  }

  @Override
  public void writeBoth(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
    writer.write(formatter.format(correlation.getId(), request, response));
  }
}

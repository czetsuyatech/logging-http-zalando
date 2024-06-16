# Http Request Logging using Zalando

In some cases, it is critical that we log both internal and external HTTP requests. This is very useful for debugging communication between microservices. But this feature is already available with other Spring boot libraries. What I wanted to show in this exercise is the flexibility of logging or saving in a database of particular data.

# How to Use

## Create the following beans for the logbook to intercept the HTTP requests.

```
@Configuration
@RequiredArgsConstructor
public class WebBeansConfig {
 
  private final Logbook logbook;
 
  @Bean
  public Logbook getLogbook() {
    return Logbook.builder()
        .strategy(new StatusAtLeastStrategy(200))
        .sink(new LogSink(new LogFormatter(), new LogWriter()))
        .build();
  }
 
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
```

## Implement the request data manipulation logic.

```
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
```

## Implement a custom log model and formatter
```
public class LogFormatter {
 
  public Message format(String correlationId, HttpRequest request, HttpResponse response) throws IOException {
 
    return Message.builder()
        .correlationId(correlationId)
        .requestBody(request.getBodyAsString())
        .responseBody(response.getBodyAsString())
 
        .build();
  }
}
```

## Implement the actual logging logic

This example logs in the console, but it could be on any other storage such as database.

```
@Slf4j
public class LogWriter {
 
  // you can autowire a service here
  public void write(Message message) {
    log.debug("Http intercepted message={}", message);
  }
}
```

# Documentation

[https://www.czetsuyatech.com/2023/05/efficient-http-request-logging-in.html](https://www.czetsuyatech.com/2023/05/efficient-http-request-logging-in.html)

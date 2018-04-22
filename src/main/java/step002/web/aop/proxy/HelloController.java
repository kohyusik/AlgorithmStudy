package step002.web.aop.proxy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {
  private final ServiceTestImpl service;
  public HelloController(ServiceTestImpl service) {
    this.service = service;
    System.out.println(service.getClass());
  }
}
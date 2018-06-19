package step002.web.aop.proxy;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
  private final ServiceTestImpl service;
  public ExceptionController(ServiceTestImpl service) {
    this.service = service;
    System.out.println(service.getClass());
  }

  @ExceptionHandler(NullPointerException.class)
  public String handle(Exception e) {
    System.out.println(e);
    return null;
  }
}
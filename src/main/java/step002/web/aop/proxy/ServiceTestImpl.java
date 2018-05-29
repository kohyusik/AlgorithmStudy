package step002.web.aop.proxy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class ServiceTestImpl implements ServiceTest {
  
  public ServiceTestImpl() {
  
    System.out.println("ServiceTestImpl instance..");
  }
  
  @Async
  public void print() {
  }
}
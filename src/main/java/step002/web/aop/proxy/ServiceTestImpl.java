package step002.web.aop.proxy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class ServiceTestImpl implements ServiceTest {
  @Async
  public void print() {
  }
}
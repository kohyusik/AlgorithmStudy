package boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import step002.web.springboot.AdviceLogging;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public AdviceLogging adviceLogging() {
        return new AdviceLogging();
    }

}
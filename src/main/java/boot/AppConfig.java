package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import step002.web.interceptor.TestInterceptor;
import step002.web.springboot.AdviceLogging;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig implements WebMvcConfigurer {
    
    TestInterceptor testInterceptor;
    
    @Autowired
    public AppConfig(TestInterceptor testInterceptor) {
        this.testInterceptor = testInterceptor;
    }
    
    @Bean
    public AdviceLogging adviceLogging() {
        return new AdviceLogging();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/**/*");
    }
}
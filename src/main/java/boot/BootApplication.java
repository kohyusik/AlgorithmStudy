package boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan({"step002.web.filter"})
@ComponentScan({"step002.*", "boot"})
public class BootApplication {
    public static void main(String[] args) {
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("server.port", 9000);
//        new SpringApplicationBuilder(BootApplication.class).properties(properties).run(args);
        
        new SpringApplicationBuilder(BootApplication.class).run(args);
//        SpringApplication.run(BootApplication.class, args);
    }
}

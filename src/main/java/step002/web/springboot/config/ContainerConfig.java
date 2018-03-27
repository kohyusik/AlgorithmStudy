package step002.web.springboot.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ContainerConfig {
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return container -> {
//            TomcatEmbeddedServletContainerFactory tomcat =
//                    (TomcatEmbeddedServletContainerFactory) container;
//
//            Connector ajpConnector = new Connector("AJP/1.3");
//            ajpConnector.setProtocol("AJP/1.3");
//            ajpConnector.setPort(9090);
//            ajpConnector.setSecure(false);
//            ajpConnector.setAllowTrace(false);
//            ajpConnector.setScheme("http");
//            tomcat.addAdditionalTomcatConnectors(ajpConnector);
//        };
//    }
}
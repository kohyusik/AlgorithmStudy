package step002.web.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

//@Configuration
//@EnableWebSocket
@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        
        registry.addEndpoint("/ws")
                //                .setHandshakeHandler(new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy()))
                .setAllowedOrigins("*").withSockJS();
    }
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        
        // simple stomp broker (in memory)
        config.enableSimpleBroker("/topic");
        
        // stomp broker (using memory DB)
        /*config.enableStompBrokerRelay("/topic", "/user")
                .setRelayHost("192.168.2.134").setRelayPort(61613) // activemq
                .setSystemHeartbeatSendInterval(10000).setSystemHeartbeatReceiveInterval(10000);*/
        
        config.setApplicationDestinationPrefixes("/app");
    }
}
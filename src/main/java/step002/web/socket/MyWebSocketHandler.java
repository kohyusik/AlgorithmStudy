package step002.web.socket;

import org.springframework.web.socket.*;

import java.util.List;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-03-27
 * @description :
 */
public class MyWebSocketHandler implements WebSocketHandler {


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    
        System.out.println("connected");
    }
    
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    
        System.out.println(message);
        if (message instanceof TextMessage) {
            this.handleMessage(session, (TextMessage) message);
        }
    
    }

    public void handleMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println(message.getPayload());

        session.sendMessage(message);

    }
    
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    
    }
    
    @Override
    public boolean supportsPartialMessages() {
        
        return false;
    }
}

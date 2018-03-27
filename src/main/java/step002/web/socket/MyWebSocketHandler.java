package step002.web.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

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

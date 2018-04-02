package step002.web.socket;

import org.springframework.web.socket.*;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-03-27
 * @description :
 */
public class MyWebSocketHandler implements WebSocketHandler {

    Logger logger = Logger.getLogger("MyWebSocketHandler");

    Set<WebSocketSession> sessionSet = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        sessionSet.add(session);
        logger.info("connected : " + session.getId());
        logger.info("session list : " + sessionSet);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

        logger.info(message.toString());
        if (message instanceof TextMessage) {
            this.handleMessage(session, (TextMessage) message);
        }

    }

    public void handleMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        System.out.println(payload);

        sessionSet.parallelStream().forEach((broadcastSession) -> {
                    try {
                        broadcastSession.sendMessage(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        for (WebSocketSession broadcastSession : sessionSet) {
            broadcastSession.sendMessage(message);
        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.warning(session.toString());
        sessionSet.remove(session);
        logger.info("session list : " + sessionSet);
        logger.info("closed : " + session.getId() + " - " + closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {

        return false;
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }
}

package step002.web.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-13
 * @description :
 */

@Controller
public class WebSocketController {
    
    private SimpMessagingTemplate simpMessagingTemplate;
    
    @Autowired
    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        
        this.simpMessagingTemplate = simpMessagingTemplate;
    }
    
    @MessageMapping("/chat")
    public void chat(SimpMessageHeaderAccessor headerAccessor) {
        
        System.out.println(headerAccessor);
        simpMessagingTemplate.convertAndSend("/topic/chat", "TESTTEST 12");
    }
    
    @GetMapping("/message/r/inbound/blockCheck")
    @ResponseBody
    public Map blockCheck(String contactMobile) {
        
        Map<String, Object> result = new HashMap<>();
        result.put("lock", true);
        return result;
    }
    
}

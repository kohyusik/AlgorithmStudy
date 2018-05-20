package step002.web.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

public class TopicMessageListener implements MessageListener {

  private RedisTemplate redisTemplate;

  @Autowired
  public void setRedisTemplate(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public void onMessage(Message message, byte[] bytes) {
    byte[] body = message.getBody();
    String str = (String) redisTemplate.getStringSerializer().deserialize(body);
//    log.info("key : {}, message : {}", new String(bytes), str);
  }
}
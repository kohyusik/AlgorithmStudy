package step002.web.springboot.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import step002.web.domain.ServerInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@Component
public class HeartBeatScehduler {

    @Autowired
    RedisTemplate redisTemplate;

    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void heartBeat() {

        try {

		    ServerInfo serverInfo = new ServerInfo();
		    serverInfo.setHostName(InetAddress.getLocalHost().getHostName());
		    serverInfo.setServerIP(InetAddress.getLocalHost().getHostAddress());

            System.out.println("Redis set server info : " + serverInfo);
            redisTemplate.opsForValue().set("spring:websocket:server:list", serverInfo, 300, TimeUnit.SECONDS);

            Object obj = redisTemplate.opsForValue().get("spring:websocket:server:list");
            ServerInfo getSi = (ServerInfo)obj;
            System.out.println(getSi.equals(serverInfo));
            System.out.println(getSi == serverInfo);
            System.out.println(redisTemplate.keys("spring:websocket:server*"));

            for (Object key:redisTemplate.keys("spring:websocket:server*")) {
                System.out.println(key);
                System.out.println(redisTemplate.opsForValue().get(key));
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}

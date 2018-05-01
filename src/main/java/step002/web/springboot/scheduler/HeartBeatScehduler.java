package step002.web.springboot.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class HeartBeatScehduler {

    @Autowired
    RedisTemplate redisTemplate;

    @Scheduled(fixedRate = 5000)
    public void heartBeat() {

        String thisIpAddress = "";
        try {

		    System.out.println("REDIS INSERT");
            thisIpAddress = InetAddress.getLocalHost().getHostAddress();
            redisTemplate.opsForValue().set("spring:websocket:server:list", thisIpAddress, 3, TimeUnit.SECONDS);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}

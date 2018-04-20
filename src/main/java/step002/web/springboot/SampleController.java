package step002.web.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@EnableAutoConfiguration
public class SampleController {
    
    Logger logger = Logger.getLogger("MyWebSocketHandler");

    @RequestMapping("/")
    @ResponseBody
    String main() {
        return "hello main!";
    }
    
    @CrossOrigin
    @RequestMapping("/execution")
    @ResponseBody
    String execution() {
        System.out.println("execution Controller!!");
        return "execution!!!!a!";
    }
    
    @RequestMapping(value = "/test", method = { RequestMethod.GET })
    @ResponseBody
    public Map test(HttpServletRequest request) {
        
        logger.fine("************ TEST ************");

        Map<String, String> pathVal = new HashMap<>();
        pathVal.put("test1", "path1");
        pathVal.put("test", "path");
        pathVal.put("type", "pathType");
        pathVal.put("test99", "path999");
        pathVal.put("test2", "path2");
        pathVal.put("param3", "param3");

        UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance();
        uriComponents.scheme("http").host("localhost").port(8080)
                .path("/login/{test1}/{test2}")
                .path("/{test}")
                .path("/{type}");
        
        uriComponents.queryParam("param1", 23222);
        uriComponents.queryParam("param2");
        uriComponents.queryParam("param3", "{param3}");
        String uri  = uriComponents.build().expand(pathVal).toString();
    
        Map<String, String> result = new HashMap<>();
        result.put("uristr", uriComponents.toUriString());
        result.put("uri", uri);
        result.put("request", request.getRequestURI());
        result.put("querystring", request.getQueryString());
        result.put("sessionId", request.getAuthType());
        return result;
    }
    

}
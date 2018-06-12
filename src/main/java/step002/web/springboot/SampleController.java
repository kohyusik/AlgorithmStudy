package step002.web.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import step002.web.annotation.ConvertTarget;
import step002.web.aop.proxy.ServiceTest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
public class SampleController {

    private final ServiceTest service;
    
    @Autowired
    public SampleController(ServiceTest service) {
        this.service = service;
        System.out.println("service!!!!!!!!!!!!!!!!!!!");
        System.out.println(service.getClass() + "@");
        System.out.println(this.getClass());
    }
    
    Logger logger = Logger.getLogger("MyWebSocketHandler");

    @RequestMapping("/")
    @ResponseBody
    String main(HttpServletRequest request) {
    
        System.out.println("@@@@@@");
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
        return "hello main!";
    }

    @CrossOrigin
    @RequestMapping("/execution")
    @ResponseBody
    @ConvertTarget
    String execution(HttpServletRequest request, @ConvertTarget String t1, String t2) {
        System.out.println("execution Controller!!");
        String t1p = request.getParameter("t1");

        System.out.println(t1);
        System.out.println(t2);
//
//        if (true) throw new NullPointerException();

        return "execution!!!!a!";
    }
    
    @RequestMapping(value = "/testList/t", method = { RequestMethod.GET })
    @ResponseBody
    public Map test(HttpServletRequest request, String[] paramList) {
    
        System.out.println("************ TEST ************");
        
        for (int i = 0; i < paramList.length; i++) {
            System.out.println(paramList[i]);
        }
//        paramList.forEach((str) -> System.out.println(str));
    
        Map<String, String> result = new HashMap<>();
        result.put("request", request.getRequestURI());
        result.put("querystring", request.getQueryString());
        result.put("sessionId", request.getAuthType());
        return result;
    }
    
//    @RequestMapping(value = "/testListJson", method = { RequestMethod.GET })
//    @ResponseBody
//    public Map testListJson(HttpServletRequest request, @RequestBody String[] paramList) {
//
//        System.out.println("************ TEST ************");
//
//        for (int i = 0; i < paramList.length; i++) {
//            System.out.println(paramList[i]);
//        }
////        paramList.forEach((str) -> System.out.println(str));
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("request", paramList);
//        return result;
//    }
    
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

    @RequestMapping(value = "/postTest", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map postTest(
//            @RequestParam(value = "api1", required = true) String api1,
//            @RequestParam(value = "api2", required = true) String api2
//            @RequestBody Map api1,
            @RequestBody TestClass<TestClass.TestInnerClass> body
    ) {

//        System.out.println(api1.toString());
        System.out.println(body);
        System.out.println(body.getApi3());

        return new HashMap();
    }

}
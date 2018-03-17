package step002.web.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "hello world!!!!";
    }

    @RequestMapping("/execution")
    @ResponseBody
    String execution() {
        System.out.println("execution Controller!!");
        return "execution!!!!!";
    }

}
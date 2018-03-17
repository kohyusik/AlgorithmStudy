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
    String main() {
        return "hello main!";
    }

    @RequestMapping("/execution")
    @ResponseBody
    String execution() {
        System.out.println("execution Controller!!");
        return "execution!!!!a!";
    }

}
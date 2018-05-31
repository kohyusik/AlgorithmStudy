package step002.web.aop.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-05-29
 * @description :
 */
public class ServiceAdvice implements Advice, Advisor {
    
    @Override
    public Advice getAdvice() {
        
        return new ServiceAdvice();
    }
    
    @Override
    public boolean isPerInstance() {
        
        return false;
    }
}

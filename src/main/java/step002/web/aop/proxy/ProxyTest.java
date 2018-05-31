package step002.web.aop.proxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-05-29
 * @description :
 */
public class ProxyTest {
    
    public static void main(String[] args) {
    
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(ServiceTest.class);
        proxyFactory.setTarget(new ServiceTestImpl());
        proxyFactory.addAdvice(new ServiceAdvice());
        final ServiceTest proxy = (ServiceTest) proxyFactory.getProxy();
        System.out.println(proxy.getClass());
    
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new ServiceTestImpl());
//        proxyFactory.addAdvice(new ServiceAdvice());
//        ServiceTestImpl proxy = (ServiceTestImpl) proxyFactory.getProxy();
//        System.out.println(proxy.getClass());
    }
    
}

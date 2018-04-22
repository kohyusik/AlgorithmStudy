package step002.web.aop;

import com.sun.tools.attach.VirtualMachine;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import sun.management.Agent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class Foo {
    public void setBar() {
        throw new UnsupportedOperationException("should not go here");
    }

    public void redirected() {
        System.out.println("Yiha");
    }

    public static void main(String[] args) {

        Foo foo = new Foo();
        ProxyFactory pf = new ProxyFactory(foo);

        pf.addAdvice(new MethodInterceptor() {
            public Object invoke(MethodInvocation mi) throws Throwable {
                if (mi.getMethod().getName().startsWith("set")) {
                    Method redirect = mi.getThis().getClass().getMethod("redirected");
                    redirect.invoke(mi.getThis());
                }
                return null;
            }
        });

        Foo proxy = (Foo) pf.getProxy();
        proxy.setBar(); // prints "Yiha"

    }

}

/**
 * 
 */
package step002.web.springboot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
public class AdviceLogging {

    @Pointcut("within(step002.web.springboot.*)")
    private void pointcutMethod(){}

	Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("pointcutMethod()") //around가 적용될 포인트컷을 명시 : pointcutMethod()
//	public void loggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		logger.info("method path : " + joinPoint.getSignature());
//
//        System.out.println("around 1111");
//
//        joinPoint.proceed();
//
//        System.out.println("around 2222");
//
//	}
//
//    @Before("pointcutMethod()")
//    public void testBefore(){
//        System.out.println("beforeMethod()실행 zzzzzzzzz");
//    }
//
//    @Before("within(step002..*)")
//    public void beforeMethod(){
//        System.out.println("beforeMethod()실행");
//    }

    @Around("execution(* step002..*.*execution(..))")
    public Object executionAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("executionAround BEFORE");

        Object returnVal = joinPoint.proceed();

        System.out.println("executionAround AFTER");

        return returnVal;

    }

    @Before("execution(* step002..*.*execution(..))")
    public void executionBefore(JoinPoint joinPoint) {
        System.out.println("executionBefore");
    }

    @Before("execution(* step002..*.*print(..))")
    public void printBefore(JoinPoint joinPoint) {
        System.out.println("print before");
    }

    @After("execution(* step002..*.*execution(..))")
    public void executionAfter(JoinPoint joinPoint) {
        System.out.println("executionAfter");
    }

    @AfterReturning(pointcut = "execution(* step002..*.*execution(..))", returning = "returnValue")
    public Object executionAfterReturning(Object returnValue) {
        System.out.println("executionAfterReturning");
        System.out.println("return value : " + String.valueOf(returnValue));
        return returnValue;
    }


    @Around("@annotation(step002.web.annotation.ConvertTarget)")
    public Object aroundConvert(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();

        Method method = signature.getMethod();

        if ( method.getDeclaringClass().isInterface() ) {
            method = pjp.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
        }


        Annotation[][] annotations = method.getParameterAnnotations();

        Object[] args = pjp.getArgs();

        for ( int i=annotations.length-1 ; i>=0; i-- ) {
            System.out.println(annotations[i].length);
            for (int j = 0; j < annotations[i].length; j++) {
                if ("step002.web.annotation.ConvertTarget".equals(annotations[i][j].annotationType().getName())) {
                    System.out.println(annotations[i][j]);
                    System.out.println(annotations[i][j].annotationType().getName());
                }
            }

//            args[i] = resolver.findConvertAnnotationsAndconvert(annotations[i], args[i]);
        }

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        if (true) throw new NullPointerException();
        System.out.println(pjp);
        System.out.println(method);
        System.out.println(annotations);
        System.out.println(args);
        for (Object arg:args) {
            System.out.println(arg);

        }
        System.out.println(method.getDeclaredAnnotations()[0]);
        System.out.println(method.getDeclaredAnnotations()[1]);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        Object returnObj = pjp.proceed(args);
//
//        return resolver.findConvertAnnotationsAndconvert(method.getDeclaredAnnotations(), returnObj);

        return returnObj;
    }





}
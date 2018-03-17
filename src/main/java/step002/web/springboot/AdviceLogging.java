/**
 * 
 */
package step002.web.springboot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
public class AdviceLogging {

    @Pointcut("within(step002.web.springboot.*)")
    private void pointcutMethod(){
    }

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


    @Before("execution(* step002..*.*execution(..))")
    public void executionBefore(JoinPoint joinPoint) {
        System.out.println("executionBefore");
    }

    @After("execution(* step002..*.*execution(..))")
    public void executionAfter(JoinPoint joinPoint) {
        System.out.println("executionAfter");
    }

    @Around("execution(* step002..*.*execution(..))")
    public void executionAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("executionAround BEFORE");

        joinPoint.proceed();

        System.out.println("executionAround AFTER");

    }

}
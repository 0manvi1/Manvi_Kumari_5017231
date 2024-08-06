package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	/*
	 * @Pointcut("execution(* com.library.service..*(..))") public void
	 * serviceMethods() { }
	 */

/*    // Advice that runs before the method execution
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().toShortString());
    }

    // Advice that runs after the method execution
    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Method executed: " + joinPoint.getSignature().toShortString());
    }*/

     @Before("execution(* com.library.service.BookService.*(..))")
     public void logBefore(JoinPoint joinPoint) {
         System.out.println("Before method: " + joinPoint.getSignature().getName());
     }

     @After("execution(* com.library.service.BookService.*(..))")
     public void logAfter(JoinPoint joinPoint) {
         System.out.println("After method: " + joinPoint.getSignature().getName());
     }
}

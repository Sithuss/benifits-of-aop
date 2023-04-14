package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyCurrencyServiceAspect {
    @Pointcut("within(com.demo.service.*)") // within -> all classes in this package
    public void withinPointCut() {}

    @Pointcut("@within(com.demo.annotation.Secured)")
    public void annotationWithinPointCut() {}

    @Pointcut("@annotation(com.demo.annotation.Transaction)")
    public void annotationPointCut() {}

    @Before("withinPointCut() && annotationPointCut()")
    public  void combinationAdvice(JoinPoint joinPoint) {
        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
    @Pointcut("bean(my_bean)")
    public void banPointcut(){}

    @Pointcut("args(int, double )")
    public void argsPointCut() {}

    @Pointcut("@args(com.demo.annotation.Validated)")
    public void annotationArgsPointCut() {}

    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetPointCut() {}

    @Pointcut("execution(public * *(..))")
    public void changeCurrencyPointCut() {}

//    @Before("changeCurrencyPointCut()")
    public void executionBeforeAdvice(JoinPoint joinPoint) {
        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @Before("targetPointCut()")
    public void targetAnnotationAdvice(JoinPoint joinPoint) {
        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @AfterThrowing(value = "annotationArgsPointCut()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception){
        System.out.println("exception cause");
    }

//    @AfterReturning(value = "annotationArgsPointCut()", returning = "name")
    public void afterReturningAdvice(JoinPoint joinPoint, String name) {

        System.out.println(
                String.format("%s is invoked before with:%s and return value:[%s]", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()), name)
        );
    }

//    @Before("annotationArgsPointCut()")
    public void annotationBeforeCurrencyType(JoinPoint joinPoint) {

        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @Before("argsPointCut()")
    public void argsBeforeAdvice(JoinPoint joinPoint) {
        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @Before("banPointcut()")
    public void beanBeforeAdvice(JoinPoint joinPoint){

        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @Before("annotationPointCut()")
    public void annotationBeforeAdvice(JoinPoint joinPoint) {
        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @Before("annotationWithinPointCut()")
    public void beforeWithinAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @Before("withinPointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint) {

        System.out.println(
                String.format("%s is invoked within with:%s", joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
}

package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExampleAspect {
  public boolean aspectWasInvoked = false;

  @Pointcut("execution(* com.example.Something.doSomething(..))")
  protected void monitorDoSomething() {
  }

  @Around(value = "monitorDoSomething()")
  public Object aroundMonitorDoSomething(ProceedingJoinPoint pjp) throws Throwable {
    aspectWasInvoked = true;
    return pjp.proceed();
  }
}

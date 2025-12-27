package com.example.railwaystationissuetrackingsystem.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Around("execution(* com.example.railwaystationissuetrackingsystem.service..*(..))")
    public Object testAop(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("🔥 AOP HIT: " + pjp.getSignature());

        return pjp.proceed();
    }
}

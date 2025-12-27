package com.example.railwaystationissuetrackingsystem.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAopAspect {

    @Around(
      "execution(* com.example.railwaystationissuetrackingsystem.service.UserService.getAllUsers(..))"
    )
    public Object aroundGetAllUsers(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("AOP BEFORE getAllUsers()");

        Object result = pjp.proceed();

        System.out.println("AOP AFTER getAllUsers()");

        return result;
    }
}

package org.example.expert.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminAuditLogAspect {

    @Around("@annotation(audit)")
    public Object around(ProceedingJoinPoint jp, AdminAuditLog audit) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = jp.proceed();

        return proceed;

    }
}

package com.nancy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.aop
 * @Description: 登录拦截器
 * @author: guangfeng.zhou
 * @date: 2017/12/8 12:47
 */
@Component
@Aspect
public class LoginAspect {
    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Autowired
    private  HttpServletRequest request;

    @Pointcut("within(com.nancy.controller..*) && !within(com.nancy.controller.LoginController)")
    public void loginCheck(){

    }

    @Before(value = "loginCheck()")
    public void before(JoinPoint point){

    }

    @Around("loginCheck()")
    public Object around(ProceedingJoinPoint point){
        logger.info("=====需要先登录======");

        Object obj = null ;
        try {
            obj = point.proceed() ;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj ;
        //        return "redirect:/login";
    }

    @AfterReturning(pointcut = "loginCheck()", returning = "retVal")
    public void afterReturning(JoinPoint point, Object retVal){

    }

    @AfterThrowing(pointcut= "loginCheck()", throwing = "e")
    public void afterThrowing(JoinPoint point, Throwable e){

    }

}

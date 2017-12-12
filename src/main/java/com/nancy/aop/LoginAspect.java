package com.nancy.aop;

import com.nancy.dao.MagUserMapper;
import com.nancy.entity.dto.ResponseMsg;
import com.nancy.entity.model.MagUser;
import com.nancy.utils.UserUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

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

    ThreadLocal<Long> startTime = new ThreadLocal<>() ;

    @Resource
    private UserUtils userUtils ;

    private MagUser magUser ;

    @Pointcut("within(com.nancy.controller..*) && !within(com.nancy.controller.CommonController)")
    public void loginCheck(){

    }

    @Before(value = "loginCheck()")
    public void before(JoinPoint point){
        logger.info("====={}  invoke begin===================", point.getSignature().getDeclaringTypeName());
        startTime.set(System.currentTimeMillis());
        magUser = userUtils.getUserByName() ;
    }

    @Around("loginCheck()")
    public Object around(ProceedingJoinPoint pjp){
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); // 获取被拦截的方法
        String methodName = method.getName();  // 获取被拦截的方法名

        Object obj = null ;
        try {
            if(magUser==null || StringUtils.isEmpty(magUser.getUserId())){
                logger.info("=====请先登录MAG系统======");
                return "redirect:/login/login";
//                return new ResponseMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "请先登录MAG系统");
            }

            obj = pjp.proceed() ;
        } catch (Throwable throwable) {
            logger.info("=====执行方法异常======");
            return new ResponseMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "执行方法异常");
        }finally {
            logger.info("====={}.{} invoke end , cost time {}ms.", signature.getDeclaringTypeName(), methodName, System.currentTimeMillis()-startTime.get());
        }

        return obj ;
    }

    @AfterReturning(pointcut = "loginCheck()", returning = "retVal")
    public void afterReturning(JoinPoint point, Object retVal){

    }

    @AfterThrowing(pointcut= "loginCheck()", throwing = "e")
    public void afterThrowing(JoinPoint point, Throwable e){
    }

}

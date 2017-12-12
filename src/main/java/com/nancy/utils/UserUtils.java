package com.nancy.utils;

import com.github.pagehelper.util.StringUtil;
import com.google.gson.Gson;
import com.nancy.entity.model.MagUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.utils
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/9 16:25
 */
@Component
public class UserUtils {
    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Resource
    private HttpServletRequest request;

    /**
     * 根据用户ID, 获得用户信息
     * @param:
     * @return:
     */
    public MagUser getUserByName(){
        MagUser magUser  = null ;
        try {
            magUser  = (MagUser) request.getSession().getAttribute(Contants.LOGIN_USER) ;
        }catch (Exception ex){
            logger.error("===get user info fail");
        }
        logger.info("===user info {} ", new Gson().toJson(magUser));
        return magUser ;
    }

    /**
     * 登录用户 存放session
     * @param:
     * @return:
     */
    public boolean putUserSession(MagUser magUser){
        try {
            logger.info("===putUserSession user={} in session  ", new Gson().toJson(magUser));
            request.getSession().setAttribute(Contants.LOGIN_USER, magUser);
        }catch (Exception ex){
            logger.error("===putUserSession fail ", ex);
            return false ;
        }
        return true ;
    }

    /**
     * 根据用户ID, 清除用户信息
     * @param: userId
     * @return:
     */
    public boolean clearUserSession(){
        try {
            request.getSession().removeAttribute(Contants.LOGIN_USER);
        }catch (Exception ex){
            logger.error("===clearUserSession fail ", ex);
            return false ;
        }
        return true ;
    }


}

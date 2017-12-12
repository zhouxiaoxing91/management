package com.nancy.controller;

import com.nancy.entity.dto.ResponseMsg;
import com.nancy.entity.model.MagUser;
import com.nancy.exception.LoginException;
import com.nancy.service.MagUserService;
import com.nancy.utils.UserUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.controller
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/8 12:54
 */
@Controller
@RequestMapping("/login")
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Resource
    private MagUserService magUserService ;
    @Resource
    private UserUtils      userUtils ;

    @RequestMapping("/login")
    public String forward(){
        return "login" ;
    }

    @RequestMapping("/out")
    public String loginout(){
        return "login" ;
    }

    @RequestMapping(value = "/in", method={ RequestMethod.POST})
    @ResponseBody
    public ResponseMsg loginin(@RequestBody Map map){
        logger.info("========loginin param={}", map);
        ResponseMsg responseMsg = new ResponseMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString(), null) ;

        try {
            logger.info("========校验登录入参。。。。。");
            checkRequset(map) ;
        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            responseMsg.setMsg(ex.getMessage());
            return responseMsg ;
        }

        String userId = MapUtils.getString(map, "userId") ;
        String password = MapUtils.getString(map, "password") ;
        MagUser magUser = magUserService.findUserByID(userId) ;
        if(magUser!=null && password.equals(magUser.getPassword())){
            logger.info("========登录成功。。。。。");
            userUtils.clearUserSession() ;
            userUtils.putUserSession(magUser) ;
            responseMsg.setCode(HttpStatus.OK.toString());
            responseMsg.setMsg("登录成功");
        }else {
            logger.info("========用户名不存在或密码错误=============");
            responseMsg.setMsg("用户名不存在或密码错误");
        }

        return responseMsg ;
    }


    private void checkRequset(Map map) throws LoginException {
        String userId = MapUtils.getString(map, "userId") ;
        String password = MapUtils.getString(map, "password") ;

        if(userId==null || "".equals(userId.trim()) ){
            throw new LoginException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "登录名不可为空") ;
        }
        if(password==null || "".equals(password.trim()) ){
            throw new LoginException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "密码不可为空") ;
        }

    }
}

package com.nancy.controller;

import com.nancy.service.MagUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
public class LoginController {

    @Resource
    private MagUserService magUserService ;

    @RequestMapping("")
    public String forward(){
        return "login" ;
    }

    @RequestMapping("/out")
    public String loginout(){
        return "login" ;
    }

    @RequestMapping("/in")
    public String loginin(){


        return "login" ;
    }
}

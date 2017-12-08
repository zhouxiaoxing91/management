package com.nancy.controller;

import com.nancy.entity.dto.ResponseMsg;
import com.nancy.service.MagUserService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.controller
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/7 22:33
 */
@Controller
@RequestMapping("/basic")
public class MagUserController {
    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Resource
    private MagUserService magUserService ;

    @RequestMapping("/user")
    @ResponseBody
    public ResponseMsg findUserByName(@RequestBody Map<String, String> map){
        logger.info("request param =" + map);
        ResponseMsg responseMsg = new ResponseMsg() ;

        String name = MapUtils.getString(map, "name") ;
        responseMsg.setCode(HttpStatus.OK.toString());
        responseMsg.setData(magUserService.findUserByName(name));
        return responseMsg;
    }

    @RequestMapping("")
    public String index(){
        return "index";
    }

}

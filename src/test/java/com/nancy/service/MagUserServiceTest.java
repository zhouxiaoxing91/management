package com.nancy.service;

import com.google.gson.Gson;
import com.nancy.BaseJunit;
import com.nancy.entity.model.MagUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.service
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/7 22:25
 */
public class MagUserServiceTest extends BaseJunit {

    @Autowired
    private MagUserService magUserService ;

    private Logger logger = LoggerFactory.getLogger(getClass()) ;


    @Before
    public void before(){
    }

    @After
    public void after(){
    }

    @Ignore
    @Test
    public void findUserByNameTest(){
        List<MagUser> listUser = magUserService.findUserByName("小妮") ;

        logger.info("user info" + new Gson().toJson(listUser));

    }




}

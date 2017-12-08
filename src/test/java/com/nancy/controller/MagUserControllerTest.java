package com.nancy.controller;

import com.google.gson.Gson;
import com.nancy.BaseJunit;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.controller
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/8 11:38
 */
public class MagUserControllerTest extends BaseJunit {
    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @After
    public void tearDown() throws Exception {

    }

//    @Ignore
    @Test
    public void findUserByNameTest() throws Exception {

        Map<String, Object> mapJson = new HashMap<>() ;
        mapJson.put("name", "小妮") ;

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/basic/user").  //请求的url,请求的方法是 post
                         contentType(
                        MediaType.APPLICATION_JSON_UTF8).                             // 数据的格式
                        content(
                        new Gson().toJson(mapJson))).                                                     // 实际数据
                        andDo(
                MockMvcResultHandlers.print()).                                 // 打印出请求和相应的内容
                  andReturn();

        //        String responseString = mvcResult.getResponse().getContentAsString() ;
        //        System.out.println("--------返回的json = " + responseString);
    }
}

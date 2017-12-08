package com.nancy.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.nancy.BaseJunit;
import com.nancy.entity.model.MagUser;
import com.nancy.utils.UUId;
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
 * @Package: com.nancy.mybatis
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/7 14:00
 */
public class MagUserMapperTest extends BaseJunit{

    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Autowired
    private MagUserMapper magUserMapper ;

    @Ignore
    @Test
    public void msgUserTest(){
        MagUser magUser = new MagUser() ;
        magUser.setId(UUId.getUUid());
        magUser.setUserAddress("穿山街道22");
        magUser.setUserName("罗小妮21");
        magUser.setUserPhone("13294103755") ;
        logger.info("magUser" + new Gson().toJson(magUser));

        magUserMapper.insertSelective(magUser) ;
    }

    @Ignore
    @Test
    public void pageHelperTest(){
        PageHelper.startPage(1, 1) ;
        List<MagUser> list = magUserMapper.findUserByName("小妮") ;
        PageInfo page = new PageInfo(list);
        logger.info("magUser" + new Gson().toJson(list));
    }
}

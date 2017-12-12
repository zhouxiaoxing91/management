package com.nancy.service.impl;

import com.nancy.dao.MagUserMapper;
import com.nancy.entity.model.MagUser;
import com.nancy.service.MagUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.service.impl
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/7 22:13
 */
@Service
public class MagUserServiceImpl implements MagUserService {

    private Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Autowired
    private MagUserMapper magUserMapper ;

    @Override public List<MagUser> findUserByName(String name) {
        return magUserMapper.findUserByName(name) ;
    }

    @Override public MagUser findUserByID(String userId) {
        return magUserMapper.selectByPrimaryKey(userId);
    }
}

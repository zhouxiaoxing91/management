package com.nancy.service;

import com.nancy.entity.model.MagUser;

import java.util.List;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.service
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/7 22:11
 */
public interface MagUserService {

    /**
     * 根据用户名称，模糊查询获得用户信息
     * @param: name
     * @return:
     */
    public List<MagUser> findUserByName(String name) ;

    /**
     * 根据用户ID，获得用户信息
     * @param: name
     * @return:
     */
    public MagUser findUserByID(String userId) ;

}

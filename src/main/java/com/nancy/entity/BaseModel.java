package com.nancy.entity;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.entity
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/8 12:36
 */
public class BaseModel implements Serializable, Cloneable {

    private static final long serialVersionUID = 6464019151979101112L;

    public BaseModel(){

    }

    @Override public String toString() {
        try {
            return new Gson().toJson(this);
        }catch (Exception ex){
            return this.toString() ;
        }
    }
}

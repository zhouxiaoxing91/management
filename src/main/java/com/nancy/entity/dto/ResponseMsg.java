package com.nancy.entity.dto;

import com.nancy.entity.BaseModel;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.entity.dto
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/12/7 22:36
 */
public class ResponseMsg extends BaseModel {

    private String code; // 是否成功 200成功 其他失败
    private Object data; // 成功时返回的数据
    private String msg;  // 信息

    public ResponseMsg() {
    }

    // 成功时的构造器
    public ResponseMsg(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    // 错误时的构造器
    public ResponseMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

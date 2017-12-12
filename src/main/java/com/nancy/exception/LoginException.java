package com.nancy.exception;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: management
 * @Package: com.nancy.exception
 * @Description: 登录异常类
 * @author: guangfeng.zhou
 * @date: 2017/12/11 12:50
 */
public class LoginException extends Exception {

    private String code ;
    private String msg ;

    public LoginException(){
        super();
    }

    public LoginException(String msg){
        super(msg);
        this.msg = msg ;
    }

    public LoginException(String msg, String code){
        super(msg);
        this.msg = msg ;
        this.code = code ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

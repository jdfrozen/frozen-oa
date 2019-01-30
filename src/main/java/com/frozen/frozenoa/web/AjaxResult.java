package com.frozen.frozenoa.web;

import java.io.Serializable;

/**
 * @Auther: Frozen
 * @Date: 2019/1/30 16:53
 * @Description: Ajax操作消息提醒
 */
public class AjaxResult <T> implements Serializable {
    public static final int FAILED = 0;
    public static final int SUCCESS = 1;
    public static final String SUCCESS_MSG = "操作成功!";
    public static final String FAILED_MSG = "操作失败!";
    protected int code;
    protected String msg;
    protected T data;

    public AjaxResult() {
        this.code = 1;
        this.msg = "操作成功!";
    }

    public AjaxResult(T data) {
        this.code = 1;
        this.msg = "操作成功!";
        this.data = data;
    }

    public AjaxResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


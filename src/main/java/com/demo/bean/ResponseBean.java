package com.demo.bean;

import com.alibaba.fastjson.JSONObject;


public class ResponseBean {
    public final static boolean SUCCESS = true;
    public final static boolean FAULT = false;

    private boolean success;
    private Object message;

    public ResponseBean(boolean success) {
        this.success = success;
    }

    public ResponseBean(boolean success, Object message) {
        this.success = success;
        this.message = message;
    }

    public String toString() {
        JSONObject re = new JSONObject();
        re.put("success", success);
        if (message != null) {
            re.put("message", message);
        }
        return re.toString();
    }
}

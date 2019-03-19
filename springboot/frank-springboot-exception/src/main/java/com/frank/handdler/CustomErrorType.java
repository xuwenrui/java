package com.frank.handdler;

/**
 * @description: 返回信息
 * @author: xu.wr
 * @create: 2019-03-14 14:41
 **/
public class CustomErrorType {
    private int result;
    private String message;

    public CustomErrorType(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.test.dto;

import java.io.Serializable;

/**
 * 返回数据
 *
 * @author xueyuan
 * @dater 2016-12-8 0008.
 */
public class ResultMsgDto  implements Serializable {

    private int resultCode;
    private Object resultObject;
    private String resultMsg;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

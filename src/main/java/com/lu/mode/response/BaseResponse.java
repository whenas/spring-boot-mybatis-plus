package com.lu.mode.response;

import java.io.Serializable;

/**
 * Created by 卢松炯 on 2018/9/2.
 */
public class BaseResponse<T> implements Serializable {
    protected Integer returnCode;
    protected String message;
    protected T dataInfo;

    public BaseResponse() {
    }

    public Integer getReturnCode() {
        return this.returnCode;
    }

    public String getMessage() {
        return this.message;
    }

    public T getDataInfo() {
        return this.dataInfo;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDataInfo(T dataInfo) {
        this.dataInfo = dataInfo;
    }

    public String toString() {
        return "BaseResponse(returnCode=" + this.getReturnCode() + ", message=" + this.getMessage() + ", dataInfo=" + this.getDataInfo() + ")";
    }
}

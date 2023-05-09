package com.it.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Zhiwei Wang
 * @version $
 * @name ReturnData
 * @description 响应数据结构封装
 * @date 2022/1/18 20:59
 * @history
 */
public class ReturnData<T> {
    private String status; // 状态码

    private String msg; // 提示语

    private T data;  // 数据集合

    public static <T> ReturnData<T> SUCCESS(T data) {
        return new ReturnData<T>(Status.SUCCESS.status, Status.SUCCESS.msg, data);
    }

    public static <T> ReturnData<T> SUCCESS(String msg) {
        return new ReturnData<T>(Status.SUCCESS.status, msg);
    }

    public static <T> ReturnData<T> SUCCESS() {
        return new ReturnData<T>(Status.SUCCESS.status, Status.SUCCESS.msg);
    }

    public static <T> ReturnData<T> GET_SUCCESS(T data) {
        return new ReturnData<T>(Status.GET_SUCCESS.status, Status.GET_SUCCESS.msg, data);
    }

    public static <T> ReturnData<T> GET_SUCCESS(String msg) {
        return new ReturnData<T>(Status.GET_SUCCESS.status, msg);
    }

    public static <T> ReturnData<T> GET_SUCCESS() {
        return new ReturnData<T>(Status.GET_SUCCESS.status, Status.GET_SUCCESS.msg);
    }


    public static <T> ReturnData<T> ADD_SUCCESS() {
        return new ReturnData<T>(Status.ADD_SUCCESS.status, Status.ADD_SUCCESS.msg);
    }


    public static <T> ReturnData<T> EDIT_SUCCESS() {
        return new ReturnData<T>(Status.EDIT_SUCCESS.status, Status.EDIT_SUCCESS.msg);
    }



    public static <T> ReturnData<T> ADD_SUCCESS(T data) {
        return new ReturnData<T>(Status.ADD_SUCCESS.status, Status.ADD_SUCCESS.msg,data);
    }

    public static <T> ReturnData<T> DELETE_SUCCESS() {
        return new ReturnData<T>(Status.DELETE_SUCCESS.status, Status.DELETE_SUCCESS.msg);
    }

    public static <T> ReturnData<T> UPDATE_SUCCESS() {
        return new ReturnData<T>(Status.UPDATE_SUCCESS.status, Status.UPDATE_SUCCESS.msg);
    }

    public static <T> ReturnData<T> UPDATE_SUCCESS(T data) {
        return new ReturnData<T>(Status.UPDATE_SUCCESS.status, Status.UPDATE_SUCCESS.msg,data);
    }

    public static <T> ReturnData<T> FAIL(String msg) {
        return new ReturnData<T>(Status.FAIL.status, msg);
    }

    public static <T> ReturnData<T> FAIL() {
        return new ReturnData<T>(Status.FAIL.status, Status.FAIL.msg);
    }

    public static <T> ReturnData<T> GET_FAIL(String msg) {
        return new ReturnData<T>(Status.GET_FAIL.status, msg);
    }

    public static <T> ReturnData<T> GET_FAIL() {
        return new ReturnData<T>(Status.GET_FAIL.status, Status.FAIL.msg);
    }

    public static <T> ReturnData<T> ERROR_ACCOUNT() {
        return new ReturnData<T>(Status.ERROR_ACCOUNT.status, Status.ERROR_ACCOUNT.msg);
    }
    public static <T> ReturnData<T> Token_Expired() {
        return new ReturnData<T>(Status.Token_Expired.status, Status.Token_Expired.msg);
    }

    public static <T> ReturnData<T> ADD_FAIL() {
        return new ReturnData<T>(Status.ADD_FAIL.status, Status.ADD_FAIL.msg);
    }

    public static <T> ReturnData<T> DELETE_FAIL() {
        return new ReturnData<T>(Status.DELETE_FAIL.status, Status.DELETE_FAIL.msg);
    }

    public static <T> ReturnData<T> UPDATE_FAIL() {
        return new ReturnData<T>(Status.UPDATE_FAIL.status, Status.UPDATE_FAIL.msg);
    }

    public static <T> ReturnData<T> ERROR(String msg) {
        return new ReturnData<T>(Status.ERROR.status, msg);
    }

    public static <T> ReturnData<T> ERROR() {
        return new ReturnData<T>(Status.ERROR.status, Status.ERROR.msg);
    }


    public ReturnData(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ReturnData(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 如果字段为null,该字段不显示
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    /**
     * 返回全部字段,包括null
     *
     * @return
     */
    public String toAllString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }

}

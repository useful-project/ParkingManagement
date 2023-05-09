package com.it.common;


/**
 * @author Zhiwei Wang
 * @version $
 * @name Status
 * @description 返回信息枚举
 * @date 2022/1/18 21:01
 * @history
 */
public enum Status {

    FAIL("101", "失败")
    ,GET_FAIL("111", "查询失败")
    ,ADD_FAIL("121", "添加失败")
    ,DELETE_FAIL("131", "删除失败")
    ,UPDATE_FAIL("141", "修改失败")
    ,SUCCESS("100", "成功")
    ,GET_SUCCESS("110", "查询成功")
    ,ADD_SUCCESS("120", "添加成功")
    ,DELETE_SUCCESS("130", "删除成功")
    ,UPDATE_SUCCESS("140", "修改成功")
    ,EDIT_SUCCESS("150", "编辑成功")
    ,ERROR("201", "错误")
    ,USER_NOFOUND("211", "用户不存在")
    ,ERROR_ACCOUNT("212", "账号或密码错误")
    ,USER_EXIST("213", "用户已存在")
    ,USER_LOCK("214", "账号被锁定，请联系管理员")
    ,IP_LOCK("215", "IP 被锁定，请联系管理员")
    ,PARAM_ERROR("303", "参数错误")
    ,Token_Expired("1044", "token Invalid expired");

    public String status; // 状态码
    public String msg; // 提示语

    Status(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}

package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-12-22 09:37:26
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 184623455451296265L;
     
    private Integer id;
    /**
    * 登录名
    */ 
    private String uname;
    /**
    * 密码
    */ 
    private String upass;
    /**
    * 姓名
    */ 
    private String tname;
    /**
    * 图片文件名
    */ 
    private String filename;
    /**
    * 电话
    */ 
    private String tel;

    /**
     * email
     */
    private String email;
    /**
    * 角色
    */ 
    private String role;


    /**
     * 搜索关键字
     */
    private String key;
 
 
}

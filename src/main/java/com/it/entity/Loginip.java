package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Loginip)实体类
 *
 * @author makejava
 * @since 2022-10-15 23:08:59
 */
@Data
public class Loginip implements Serializable {
    private static final long serialVersionUID = 531230447517560304L;
     
    private Integer id;
    /**
    * 操作员
    */ 
    private String name;
    /**
    * IP地址
    */ 
    private String addr;
    /**
    * 内容
    */ 
    private String content;
    /**
    * 时间
    */ 
    private String savetime;
 
 
}

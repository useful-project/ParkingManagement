package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2022-12-18 20:53:38
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = -26620940780669276L;
     
    private Integer id;
    /**
    * 注册用户ID
    */ 
    private Integer memberid;
    /**
    * 留言内容
    */ 
    private String content;
    /**
    * 留言时间
    */ 
    private String savetime;
    /**
    * 回复内容
    */ 
    private String hfcontent;

    /**
     * 搜索关键字
     */
    private String key;
    /**
     * 注册用户对象
     */
    private Member member;
 
 
}

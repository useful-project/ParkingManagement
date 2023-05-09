package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (News)实体类
 *
 * @author makejava
 * @since 2023-02-09 18:57:12
 */
@Data
public class News implements Serializable {
    private static final long serialVersionUID = -91638862404452556L;
     
    private Integer id;
    /**
    * 标题
    */ 
    private String title;
    /**
    * 图片文件名
    */ 
    private String filename;
    /**
    * 内容
    */ 
    private String content;
    /**
    * 时间
    */ 
    private String savetime;


    /**
     * 搜索关键字
     */
    private String key;
 
 
}

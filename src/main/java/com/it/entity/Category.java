package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2023-02-13 22:13:00
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 870988779367716779L;
    /**
    * 名称
    */ 
    private Integer id;
    /**
    * 区域名称
    */ 
    private String name;
 
 /**
      搜索关键字
    */
    private String key;
 
}

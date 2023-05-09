package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Cost)实体类
 *
 * @author makejava
 * @since 2023-02-14 09:46:11
 */
@Data
public class Cost implements Serializable {
    private static final long serialVersionUID = -88255748261466259L;
    /**
    * 价格
    */ 
    private Integer id;
     
    private Double price;
 
 /**
      搜索关键字
    */
    private String key;
 
}

package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Carport)实体类
 *
 * @author makejava
 * @since 2023-02-13 22:22:02
 */
@Data
public class Carport implements Serializable {
    private static final long serialVersionUID = 678895558734278795L;
     
    private Integer id;
    /**
    * 区域ID
    */ 
    private Integer categoryid;
    /**
    * 车位号
    */ 
    private String name;
    /**
    * 状态
    */ 
    private String status;

    /**
     * 备注
     */
    private String content;

    /**
      搜索关键字
    */
    private String key;

    /**
     搜索车主或车牌号
     */
    private String key1;

    /**
     区域对象
     */
    private Category category;
 
}
